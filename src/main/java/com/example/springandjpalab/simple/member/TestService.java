package com.example.springandjpalab.simple.member;

import com.example.springandjpalab.simple.member.domain.Member;
import com.example.springandjpalab.simple.member.repository.MemberRepository;
import com.example.springandjpalab.simple.team.domain.Team;
import com.example.springandjpalab.simple.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public void test() {
        Member member = new Member(null, "member", "email", 20);
        memberRepository.save(member);
        saveTeam(member);
    }

    private void saveTeam(Member member) {
        Team team = new Team(null, "team", Arrays.asList(member));
        teamRepository.save(team);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void testSupports(Team team) {
        Member member = new Member(null, "member", "email", 20);
        memberRepository.save(member);
        System.out.println(team.getMemberList().getClass());
        team.addMember(member);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void testNested(Team team) {
        Member member = new Member(null, "member", "email", 20);
        memberRepository.save(member);
        team.addMember(member);
    }
}
