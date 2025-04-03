package com.example.springandjpalab.simple.account;

import lombok.Getter;

@Getter
public class BalanceLockInfo {
    private final BalanceRequestType balanceRequestType;
    private final Long requestNanoSecond;

    public BalanceLockInfo(BalanceRequestType balanceRequestType, Long requestNanoSecond) {
        this.balanceRequestType = balanceRequestType;
        this.requestNanoSecond = requestNanoSecond;
    }
}
