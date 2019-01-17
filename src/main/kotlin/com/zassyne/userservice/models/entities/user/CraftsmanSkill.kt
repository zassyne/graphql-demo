package com.zassyne.userservice.models.entities.user

import com.zassyne.userservice.models.entities.profile.Skill
import com.zassyne.userservice.models.entities.profile.CraftsmanProfile
import com.zassyne.userservice.models.entities.profile.Level
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity(name = "craftsman_skill")
class CraftsmanSkill {
    @EmbeddedId
    var id = CraftsmanSkillID()

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("craftsmanProfileId")
    var craftsmanProfile: CraftsmanProfile? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @MapsId("skillId")
    var skill: Skill? = null

    @Enumerated(EnumType.STRING)
    var level: Level? = null

}
