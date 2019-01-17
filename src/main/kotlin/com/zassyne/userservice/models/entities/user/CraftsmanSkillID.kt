package com.zassyne.userservice.models.entities.user

import java.io.Serializable
import javax.persistence.Column

class CraftsmanSkillID : Serializable{

    @Column(name = "craftsman_id")
    private val craftsmanProfileId: Long? = null

    @Column(name = "skill_id")
    private val skillId: Long? = null
}