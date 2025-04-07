package com.example.springandjpalab.project.order_by_arrival.presentation;

import com.example.springandjpalab.project.order_by_arrival.application.OrderByArrivalService;
import com.example.springandjpalab.project.order_by_arrival.presentation.dto.OrderByArrivalResponse;
import com.example.springandjpalab.project.order_by_arrival.presentation.dto.request.OrderByArrivalRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderByArrivalController {

    //선착순 시스템 구현
    // 선착순 쿠폰발급, 선착순 예매리
    // 선착순 1000명에서 30% 쿠폰 발급 이벤트 구현
    private final OrderByArrivalService orderByArrivalService;

    @PostMapping(value = "/api/coupon/v1/order-by-arrival")
    public OrderByArrivalResponse produceArrivalEventCoupon(@Validated @RequestBody OrderByArrivalRequest request) {
        log.info("req : {}", request);
        return orderByArrivalService.produceArrivalEventCoupon(request.getUserId(), request.isAgree());
    }


    @GetMapping(value = "/api/coupon/v1/hello")
    public String testHello(@RequestParam(value = "count") int count) {
        log.info("count = {}", count);
        return "hello" + count;
    }

}
