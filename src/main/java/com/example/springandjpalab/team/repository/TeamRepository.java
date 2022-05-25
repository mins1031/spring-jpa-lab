package com.example.springandjpalab.team.repository;

import com.example.springandjpalab.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
