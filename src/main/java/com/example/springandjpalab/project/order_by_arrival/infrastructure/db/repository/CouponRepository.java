package com.example.springandjpalab.project.order_by_arrival.infrastructure.db.repository;

import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
}
