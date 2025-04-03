package com.example.springandjpalab.project.order_by_arrival.presentation.dto;

import lombok.Getter;

@Getter
public class OrderByArrivalResponse {
    private Long userId;
    private Long produceCouponId;

    public OrderByArrivalResponse(Long userId, Long produceCouponId) {
        this.userId = userId;
        this.produceCouponId = produceCouponId;
    }
}
