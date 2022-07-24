package com.example.springandjpalab.member;

import com.example.springandjpalab.member.domain.Member;
import com.example.springandjpalab.member.repository.MemberRepository;
import com.example.springandjpalab.team.domain.Team;
import com.example.springandjpalab.team.repository.TeamRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("h2")
class TestServiceTest {

    @Autowired
    private TestService testService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @DisplayName("트랜잭셔널 전파설정 기본값이 트랜잭셔널 어노테이션이 없는 메서드도 트랜잭션에 합류시키는지 확인")
    @Test
    public void transactional_default_test() {
        //when
        testService.test();

        //then
        List<Member> members = memberRepository.findAll();
        List<Team> teams = teamRepository.findAll();

        Assertions.assertThat(members).hasSize(1);
        Assertions.assertThat(teams).hasSize(1);
    }

    @DisplayName("트랜잭셔널 전파설정 SUPPORT가 기존 트랜잭션이 없는 경우 영속성 컨텍스트를 사용할수 있는지 확인")
    @Test
    public void transactional_supported_test() {
        //given
        Team team = new Team(null, "team", null);
        teamRepository.save(team);
        Member member = new Member(null, "mem1", "email1", 21);
        member.setTeam(team);
        memberRepository.save(member);

        //when
        testService.testSupports(team);

        //then
        Team result = teamRepository.findAll().get(0);
        List<Member> members = memberRepository.findAll();

        Assertions.assertThat(members).hasSize(2);
    }


}