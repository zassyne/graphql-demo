package com.zassyne.userservice.models.entities.user

import com.fasterxml.jackson.annotation.JsonIgnore
import com.zassyne.userservice.models.entities.profile.CraftsmanProfile
import com.zassyne.userservice.models.entities.profile.Level
import com.zassyne.userservice.models.entities.profile.Skill
import org.springframework.data.jpa.repository.EntityGraph
import javax.persistence.*

@Entity(name = "craftsman_skill")
@NamedEntityGraphs(
    NamedEntityGraph(
        name = "withSkillAndProfile",
        attributeNodes = [NamedAttributeNode("skill"), NamedAttributeNode("profile")]
    )
)
class CraftsmanSkill {
    @EmbeddedId
    var id = CraftsmanSkillID()

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("craftsmanProfileId")
    var profile: CraftsmanProfile? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE, CascadeType.PERSIST])
    @MapsId("skillId")
    var skill: Skill? = null

    @Enumerated(EnumType.STRING)
    var level: Level? = null

}
