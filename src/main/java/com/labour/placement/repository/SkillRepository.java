package com.labour.placement.repository;

import com.labour.placement.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    // TODO: Define custom query methods once Entity attributes are set.
}
