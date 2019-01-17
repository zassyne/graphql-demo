package com.zassyne.userservice.models.entities.profile

import com.zassyne.userservice.models.entities.user.Craftsman
import com.zassyne.userservice.models.entities.user.CraftsmanSkill
import javax.persistence.*

@Entity
@DiscriminatorValue(value = "CRAFTSMAN_PROFILE")
class CraftsmanProfile : Profile() {

    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    var craftsmanSkills = mutableListOf<CraftsmanSkill>()

    @OneToOne(mappedBy = "craftsmanProfile", fetch = FetchType.LAZY)
    var craftsman: Craftsman? = null

    fun addSkill(skill: Skill, level: Level? = Level.INTERMEDIATE) {
        craftsmanSkills.add(CraftsmanSkill().also {
            it.profile = this
            it.level = level
            it.skill = skill
        })
    }
}
