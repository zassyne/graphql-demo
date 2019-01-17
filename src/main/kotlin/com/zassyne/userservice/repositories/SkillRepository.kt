package com.zassyne.userservice.repositories

import com.zassyne.userservice.models.entities.profile.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>