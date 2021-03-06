package com.zassyne.userservice.repositories

import com.zassyne.userservice.models.entities.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface UserRepository<T : User> : JpaRepository<T, Long>