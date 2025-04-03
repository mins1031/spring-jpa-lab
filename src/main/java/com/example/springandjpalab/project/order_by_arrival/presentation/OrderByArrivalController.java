package com.example.springandjpalab.project.order_by_arrival.presentation;

import com.example.springandjpalab.project.order_by_arrival.application.OrderByArrivalService;
import com.example.springandjpalab.project.order_by_arrival.presentation.dto.OrderByArrivalResponse;
import com.example.springandjpalab.project.order_by_arrival.presentation.dto.request.OrderByArrivalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderByArrivalController {

    //선착순 시스템 구현
    // 선착순 쿠폰발급, 선착순 예매리
    // 선착순 1000명에서 30% 쿠폰 발급 이벤트 구현
    private final OrderByArrivalService orderByArrivalService;

    @PostMapping(value = "/api/coupon/v1/order-by-arrival")
    public OrderByArrivalResponse produceArrivalEventCoupon(@Validated @RequestBody OrderByArrivalRequest request) {
        return orderByArrivalService.produceArrivalEventCoupon(request.getUserId(), request.isAgree());
    }

}
