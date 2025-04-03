package com.example.springandjpalab.simple.team.repository;

import com.example.springandjpalab.simple.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
