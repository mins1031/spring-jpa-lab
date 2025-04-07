package com.example.springandjpalab.project.order_by_arrival.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderByArrivalEvent {

    private int orderByArrivalEventCouponAmount = 100;

    public boolean isOutOfAmount() {
        return this.orderByArrivalEventCouponAmount <= 0;
    }

    public void issueCoupon() {
        log.info("쿠폰 발급! : {}", orderByArrivalEventCouponAmount);
        this.orderByArrivalEventCouponAmount--;
    }
}
