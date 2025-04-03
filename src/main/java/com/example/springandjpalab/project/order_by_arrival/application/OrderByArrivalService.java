package com.example.springandjpalab.project.order_by_arrival.application;

import com.example.springandjpalab.project.order_by_arrival.domain.OrderByArrivalEvent;
import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.entity.UserCouponEntity;
import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.entity.UserEntity;
import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.repository.UserCouponRepository;
import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.repository.UserRepository;
import com.example.springandjpalab.project.order_by_arrival.presentation.dto.OrderByArrivalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderByArrivalService {
    private final UserRepository userRepository;
    private final UserCouponRepository userCouponRepository;
    private final OrderByArrivalEvent orderByArrivalEvent;

    @Transactional
    public OrderByArrivalResponse produceArrivalEventCoupon(Long userId, boolean agree) {
        if (Objects.isNull(userId) || !agree) {
            throw new IllegalArgumentException("선착순 요청 파라미터가 부적절 합니다");
        }

        if (orderByArrivalEvent.isOutOfAmount()) {
            throw new IllegalArgumentException("쿠폰이 모두 소진 되었습니다");
        }
        long orderByArrivalEventCouponId = 135L;

        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 입니다."));
        userCouponRepository.save(
                new UserCouponEntity(userEntity.getId(), orderByArrivalEventCouponId)
        );

        return new OrderByArrivalResponse(userEntity.getId(), orderByArrivalEventCouponId);
    }
}
