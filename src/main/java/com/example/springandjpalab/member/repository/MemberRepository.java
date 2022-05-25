package com.example.springandjpalab.member.repository;

import com.example.springandjpalab.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
