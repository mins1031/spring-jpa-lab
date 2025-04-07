package com.example.springandjpalab.simple.member.domain;

import com.example.springandjpalab.simple.team.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "members"
)
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long memberNum;

    private String name;
    private String email;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public Member(Long memberNum, String name, String email, int age) {
        this.memberNum = memberNum;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
