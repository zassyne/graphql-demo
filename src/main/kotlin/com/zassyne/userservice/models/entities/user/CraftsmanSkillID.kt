package com.zassyne.userservice.models.entities.user

import java.io.Serializable
import javax.persistence.Column

class CraftsmanSkillID : Serializable {

    @Column(name = "craftsman_id")
    var craftsmanProfileId: Long? = null

    @Column(name = "skill_id")
    var skillId: Long? = null
}