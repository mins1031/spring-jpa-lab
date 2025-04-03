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
        name = "user"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String name;
    private Boolean isAgree;

    private UserEntity(Long id, String name, Boolean isAgree) {
        this.id = id;
        this.name = name;
        this.isAgree = isAgree;
    }

    public static UserEntity of(String name, Boolean isAgree) {
        return new UserEntity(null, name, isAgree);
    }
}
