package com.example.springandjpalab.simple.team.domain;


import com.example.springandjpalab.simple.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamNum;

    private String teamName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> memberList = new ArrayList<>();

    public Team(Long teamNum, String teamName, List<Member> memberList) {
        this.teamNum = teamNum;
        this.teamName = teamName;
//        this.memberList = memberList;
    }

    public void addMember(Member member) {
        this.memberList.add(member);
    }
}
