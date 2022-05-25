package com.example.springandjpalab.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long memberNum;

    private String name;
    private String email;
    private int age;

    public Member(Long memberNum, String name, String email, int age) {
        this.memberNum = memberNum;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
