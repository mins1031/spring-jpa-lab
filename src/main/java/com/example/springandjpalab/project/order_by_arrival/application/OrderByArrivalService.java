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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@Service
@RequiredArgsConstructor
public class OrderByArrivalService {
    private final UserRepository userRepository;
    private final UserCouponRepository userCouponRepository;
    private final OrderByArrivalEvent orderByArrivalEvent;

    private final ReentrantLock lock = new ReentrantLock(true);

    @Transactional
    public OrderByArrivalResponse produceArrivalEventCoupon(Long userId, boolean agree) {
        if (Objects.isNull(userId) || !agree) {
            return OrderByArrivalResponse.error(userId, "선착순 요청 파라미터가 부적절 합니다");
        }
        long orderByArrivalEventCouponId = 135L;

        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원 입니다."));
        Set<UserCouponEntity> existUserCoupons = userCouponRepository.findByUserId(userEntity.getId());

        Optional<UserCouponEntity> first = existUserCoupons.stream()
                .filter(userCouponEntity -> orderByArrivalEventCouponId == userCouponEntity.getCouponId())
                .findFirst();
        if (first.isPresent()) {
            return OrderByArrivalResponse.error(userId, "선착순 쿠폰은 인당 한개씩 입니다");
        }

        lock.lock();
        if (orderByArrivalEvent.isOutOfAmount()) {
            lock.unlock();
            return OrderByArrivalResponse.error(userId, "쿠폰이 모두 소진 되었습니다");
        }
        try {
            userCouponRepository.save(
                    new UserCouponEntity(userEntity.getId(), orderByArrivalEventCouponId)
            );
            orderByArrivalEvent.issueCoupon(userEntity.getId());
        } catch (Exception e) {
            // 이걸 issue에서 잡아서 처리해주느냐 or lock의 범위를 중복발급 검증을 위한 쿼리 + 검사로직까지 처리할것이냐. -> 속도 및 tps 보고 결정해야될것 같다.
            throw new IllegalArgumentException("userID : " + userId +  "요청 쏠림으로 인한 동일유저 요청을 배제하거나, 쿠폰이 소진되었습니다");
        } finally {
            lock.unlock();
        }

        return OrderByArrivalResponse.of(userEntity.getId(), orderByArrivalEventCouponId);
    }

    public Set<Long> getIssuedUserIds() {
        return this.orderByArrivalEvent.getIssuedUserIds();
    }
}
