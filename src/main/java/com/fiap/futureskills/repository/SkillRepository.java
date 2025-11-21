package com.fiap.futureskills.repository;

import com.fiap.futureskills.domain.skill.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
