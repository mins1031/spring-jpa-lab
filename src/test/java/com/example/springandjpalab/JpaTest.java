package com.example.springandjpalab;

import com.example.springandjpalab.member.domain.Member;
import com.example.springandjpalab.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("h2")
public class JpaTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("Save 속도 확인 without @Transactional")
    @Test
    public void BulkInsert_Save_without_Transactional() {
        //given
        int count = 100000;
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        //when & then
        for (int i = 0; i < count; i++) {
            Member member = new Member(null, "member" + i, "email" + i, i + 1);
            memberRepository.save(member);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime);

        System.out.println("걸린 시간 : " + (endTime - startTime)/1000 + "초");
    }

    @DisplayName("Save 속도 확인 with @Transactional")
    @Test
    @Transactional
    public void BulkInsert_Save_with_Transactional() {
        //given
        int count = 100000;
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        //when & then
        for (int i = 0; i < count; i++) {
            Member member = new Member(null, "member" + i, "email" + i, i + 1);
            memberRepository.save(member);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime);

        System.out.println("걸린 시간 : " + (endTime - startTime)/1000 + "초");
    }

    @DisplayName("SaveAll 속도 확인 without @Transactional")
    @Test
    public void BulkInsert_SaveAll_without_Transactional() {
        //given
        int count = 100000;
        List<Member> memberList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            memberList.add(new Member(null, "member" + i, "email" + i, i + 1));
        }

        //when & then
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        memberRepository.saveAll(memberList);

        long endTime = System.currentTimeMillis();
        System.out.println(endTime);

        System.out.println("걸린 시간 : " + (endTime - startTime)/1000 + "초");
    }

    @DisplayName("SaveAll 속도 확인 with @Transactional")
    @Test
    @Transactional
    public void BulkInsert_SaveAll_with_Transactional() {
        //given
        int count = 100000;
        List<Member> memberList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            memberList.add(new Member(null, "member" + i, "email" + i, i + 1));
        }

        //when & then
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        memberRepository.saveAll(memberList);

        long endTime = System.currentTimeMillis();
        System.out.println(endTime);

        System.out.println("걸린 시간 : " + (endTime - startTime)/1000 + "초");
    }

}
