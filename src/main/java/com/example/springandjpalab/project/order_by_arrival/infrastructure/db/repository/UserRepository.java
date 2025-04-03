package com.example.springandjpalab.project.order_by_arrival.infrastructure.db.repository;

import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
