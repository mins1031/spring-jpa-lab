package com.example.springandjpalab.project.order_by_arrival.presentation.dto;

import lombok.Getter;

@Getter
public class OrderByArrivalResponse {
    private Long userId;
    private Long produceCouponId;
    private boolean isSuccess;
    private String errMsg;

    public OrderByArrivalResponse(Long userId, Long produceCouponId, boolean isSuccess, String errMsg) {
        this.userId = userId;
        this.produceCouponId = produceCouponId;
        this.isSuccess = isSuccess;
        this.errMsg = errMsg;
    }

    public static OrderByArrivalResponse of(Long userId, Long produceCouponId) {
        return new OrderByArrivalResponse(
                userId,
                produceCouponId,
                true,
                ""
        );
    }

    public static OrderByArrivalResponse error(Long userId, String errMsg) {
        return new OrderByArrivalResponse(
                userId,
                null,
                false,
                errMsg
        );
    }
}
