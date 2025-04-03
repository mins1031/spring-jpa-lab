package com.example.springandjpalab.simple.account;

import lombok.Getter;

@Getter
public class Account {
    private Long balance;
    private Long updateMilli;
    private Long updateNano;

    public Account(Long balance, Long updateMilli, Long updateNano) {
        this.balance = balance;
        this.updateMilli = updateMilli;
        this.updateNano = updateNano;
    }

    public void deposit(Long balance, Long updateMilli, Long updateNano) {
        this.balance += balance;
        this.updateMilli = updateMilli;
        this.updateNano = updateNano;
    }

    public void withdraw(Long withdraw, Long updateMilli, Long updateNano) {
        this.balance -= withdraw;
        this.updateMilli = updateMilli;
        this.updateNano = updateNano;
    }
}
