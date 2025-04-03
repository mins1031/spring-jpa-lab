package com.example.springandjpalab.simple.account;

public enum BalanceRequestType {
    DEPOSIT("입급"),
    WITHDRAW("출금");

    private final String description;

    BalanceRequestType(String description) {
        this.description = description;
    }
}
