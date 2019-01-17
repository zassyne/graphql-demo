package com.zassyne.userservice.repositories

import com.zassyne.userservice.models.entities.user.Picture
import org.springframework.data.jpa.repository.JpaRepository

interface PictureRepository : JpaRepository<Picture, Long>