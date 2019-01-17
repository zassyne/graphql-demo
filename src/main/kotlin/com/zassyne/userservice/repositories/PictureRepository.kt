package com.zassyne.userservice.repositories

import com.zassyne.userservice.models.entities.user.Picture
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PictureRepository : JpaRepository<Picture, Long> {

    fun findByLocation(location: String): Optional<Picture>

}