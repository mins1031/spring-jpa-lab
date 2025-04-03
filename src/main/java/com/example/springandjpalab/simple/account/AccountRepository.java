package com.example.springandjpalab.simple.account;

import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class AccountRepository {

    private Map<Long, Account> accountMap = new HashMap<>();

    public Account findAccount(Long id) {
        if (Objects.isNull(accountMap.get(id))) {
            accountMap.put(id, new Account(0L, Instant.now().toEpochMilli(), (long) Instant.now().getNano()));
        }

        return accountMap.get(id);
    }
}
