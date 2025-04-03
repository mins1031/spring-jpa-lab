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
        name = "coupon"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String name;
    private boolean isLive;

    private CouponEntity(Long id, String name, boolean isLive) {
        this.id = id;
        this.name = name;
        this.isLive = isLive;
    }

    public static CouponEntity of(String name, boolean isLive) {
        return new CouponEntity(null, name, isLive);
    }
}
