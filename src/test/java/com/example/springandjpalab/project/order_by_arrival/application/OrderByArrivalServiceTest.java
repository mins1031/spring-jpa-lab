package com.example.springandjpalab.project.order_by_arrival.application;

import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.entity.UserEntity;
import com.example.springandjpalab.project.order_by_arrival.infrastructure.db.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
class OrderByArrivalServiceTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void name() {
        for (int i = 0; i < 150; i++) {
            userRepository.save(UserEntity.of("이름" + i, true));
        }
    }
}