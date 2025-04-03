package com.example.springandjpalab.project.order_by_arrival.infrastructure.db.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(
        name = "user_coupon"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private Long userId;
    private Long CouponId;

    public UserCouponEntity(Long userId, Long couponId) {
        this.userId = userId;
        CouponId = couponId;
    }
}
