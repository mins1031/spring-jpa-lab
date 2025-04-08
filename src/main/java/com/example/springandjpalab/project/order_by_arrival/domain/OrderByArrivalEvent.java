package com.example.springandjpalab.project.order_by_arrival.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class OrderByArrivalEvent {

    private int orderByArrivalEventCouponAmount = 100;
    private Set<Long> issuedUserIds = new HashSet<>();

    public boolean isOutOfAmount() {
        return this.orderByArrivalEventCouponAmount <= 0;
    }

    public void issueCoupon(Long userId) {
        if (issuedUserIds.contains(userId)) {
            throw new IllegalArgumentException();
        }
        if (this.orderByArrivalEventCouponAmount <= 0) {
            throw new IllegalArgumentException();
        }

        log.info("쿠폰 발급! : {}", orderByArrivalEventCouponAmount);
        issuedUserIds.add(userId);
        this.orderByArrivalEventCouponAmount--;
    }

    public Set<Long> getIssuedUserIds() {
        return this.issuedUserIds;
    }
}
