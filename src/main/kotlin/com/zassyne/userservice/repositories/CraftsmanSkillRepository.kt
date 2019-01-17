package com.zassyne.userservice.repositories

import com.zassyne.userservice.models.entities.user.CraftsmanSkill
import org.springframework.data.jpa.repository.JpaRepository

interface CraftsmanSkillRepository : JpaRepository<CraftsmanSkill, Long>