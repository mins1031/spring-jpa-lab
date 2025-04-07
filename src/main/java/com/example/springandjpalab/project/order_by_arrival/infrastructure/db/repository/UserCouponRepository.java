package com.example.springandjpalab.project.order_by_arrival.infrastructure.db.repository;

import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.entity.UserCouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserCouponRepository extends JpaRepository<UserCouponEntity, Long> {

    Set<UserCouponEntity> findByUserId(Long userId);
}
