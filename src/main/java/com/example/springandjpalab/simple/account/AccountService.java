package com.example.springandjpalab.simple.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    //- `/account/{id}/balance` 는 잔고 내역을 조회합니다.
    //- `/account/{id}/deposit` 은 잔고 입금을 합니다.
    //- `/account/{id}/withdraw` 는 잔고 출금을 합니다.
// 5,6에서 예외처리, 방식, 다중서버인 경우는 어떻게?, 캐시 싱글톤 처리, 출금,입금대기, 입금내역 캐싱 등에 대해 이야기

    // TODO - 잔고 조회는 단순 일단 조회. 함정이 생각 안남
    // TODO - 한명의 유저에게 잔고 입금 요청이 동시에 2개 이상 올 경우 실패합니다. 응답값은 자유입니다. + 2개 이상의 요청이 오는 경우 1개의 요청만 성공하고 나머지는 실패합니다
        // 1. 내부 메모리 캐시를 통해 유저-잔고입금 요청 을 잡아놓고 캐시에 해당 내용이 없으면 실행, 아니면 실패
        // 2. 캐시는 유저 - 순서가 중요.
    // TODO - 한명의 유저에게 잔고 입금과 출금 요청은 동시에 올 수 있고, 요청온 차례대로 실행합니다.
    // TODO - 한명의 유저에게 잔고 출금 요청이 동시에 2개 이상 올 경우 차례대로 실행합니다.

    private static ConcurrentHashMap<Long, BalanceLockInfo> balanceLockCache = new ConcurrentHashMap<>();

    private static final String DEPOSIT_DUPLICATION_MESSAGE = "입금내역은 동시에 요청할수 없습니다.";
    private static final String ACCOUNT_NOT_FOUND_MESSAGE = "조회된 계좌정보가 없습니다";
    private static final String RETRY_REQUEST_MESSAGE = "일시적인 에러가 발생했습니다. 잠시후 다시 시도해 주세요";

    @Transactional
    public Account findBalance(Long accountId) {
        return accountRepository.findAccount(accountId);
    }

    @Transactional
    public Account depositBalance(Long accountId, Long amount) {
        Account account = Optional.of(accountRepository.findAccount(accountId)).orElseThrow(() -> new RuntimeException(ACCOUNT_NOT_FOUND_MESSAGE));
        BalanceLockInfo balanceLockInfo = balanceLockCache.get(accountId);
        validCache(accountId, balanceLockInfo);

        account.deposit(amount, Instant.now().toEpochMilli(), (long) Instant.now().getNano());

        balanceLockCache.remove(accountId);

        return account;
    }

    private void validCache(Long accountId, BalanceLockInfo balanceLockInfo) {
        if (Objects.isNull(balanceLockInfo)) {
            return;
        }

        // 입금요청 동시시 실패
        if (balanceLockInfo.getBalanceRequestType().equals(BalanceRequestType.DEPOSIT)) {
            throw new RuntimeException(DEPOSIT_DUPLICATION_MESSAGE);
        }

        // 입금요청, 출긂요청 동시시 차례로 실행
        if (!checkDuplicateAccountIdRequest(accountId)) {
            throw new RuntimeException(RETRY_REQUEST_MESSAGE);
        }
    }

    @Transactional
    public Account withdrawBalance(Long accountId, Long amount) {
        Account account = Optional.of(accountRepository.findAccount(accountId)).orElseThrow(() -> new RuntimeException(ACCOUNT_NOT_FOUND_MESSAGE));
        BalanceLockInfo balanceLockInfo = balanceLockCache.get(accountId);
        validCache(accountId, balanceLockInfo);

        account.withdraw(amount, Instant.now().toEpochMilli(), (long) Instant.now().getNano());
        balanceLockCache.remove(accountId);

        return account;
    }

    private boolean checkDuplicateAccountIdRequest(Long accountId) {
        int retryCount = 0;
        int retryLimitCount = 3;
        while (retryCount < retryLimitCount) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            if (Objects.isNull(balanceLockCache.get(accountId))) {
                return true;
            }
            retryCount++;
        }

        return false;
    }
}
