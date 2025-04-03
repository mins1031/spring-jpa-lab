package com.example.springandjpalab.simple.member.repository;

import com.example.springandjpalab.simple.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
