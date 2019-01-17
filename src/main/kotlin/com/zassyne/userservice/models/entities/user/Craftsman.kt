package com.zassyne.userservice.models.entities.user

import com.zassyne.userservice.models.entities.profile.CraftsmanProfile
import javax.persistence.*

@Entity
@DiscriminatorValue(value = "CRAFTSMAN_USER")
@NamedEntityGraphs(
        NamedEntityGraph(name = "craftsmanWithProfile", attributeNodes = [NamedAttributeNode("craftsmanProfile", subgraph = "profileWithSkills")],
                subgraphs = [NamedSubgraph(name = "profileWithSkills", attributeNodes = [NamedAttributeNode("craftsmanSkills", subgraph = "craftsmanSkillsWithAll")]),
                NamedSubgraph(name = "craftsmanSkillsWithAll", attributeNodes = [NamedAttributeNode("skill")])
                ]
        ))
class Craftsman : User() {

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "profile_id")
    var craftsmanProfile: CraftsmanProfile? = null
}
