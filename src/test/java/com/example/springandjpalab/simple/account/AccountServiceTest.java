package com.example.springandjpalab.simple.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    private AccountRepository accountRepository = new AccountRepository();
    private AccountService accountService = new AccountService(accountRepository);

    @Test
    void 정상동작_테스트() {
        Account balance = accountService.findBalance(1L);
        assertEquals(balance.getBalance(), 0);
        assertEquals(10000L, accountService.depositBalance(1L, 10000L).getBalance());
        assertEquals(5000L, accountService.withdrawBalance(1L, 5000L).getBalance());
    }

    @Test
    void 입금동시_테스트() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        assertEquals(10000L, accountService.depositBalance(1L, 10000L).getBalance());

        executorService.execute(() -> accountService.depositBalance(1L, 10000L));
//        assertThrows(RuntimeException.class, () -> accountService.depositBalance(1L, 5000L));
    }
}