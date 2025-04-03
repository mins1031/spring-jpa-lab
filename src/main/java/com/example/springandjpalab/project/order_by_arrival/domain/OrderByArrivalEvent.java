package com.example.springandjpalab.project.order_by_arrival.domain;

import org.springframework.stereotype.Component;

@Component
public class OrderByArrivalEvent {

    private int orderByArrivalEventCouponAmount = 100;

    public boolean isOutOfAmount() {
        return this.orderByArrivalEventCouponAmount <= 0;
    }
}
