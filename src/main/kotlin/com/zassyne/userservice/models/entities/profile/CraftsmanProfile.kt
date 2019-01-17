package com.zassyne.userservice.models.entities.profile

import com.zassyne.userservice.models.entities.user.CraftsmanSkill
import javax.persistence.*

@Entity
@DiscriminatorValue(value = "CRAFTSMAN_PROFILE")
@NamedEntityGraphs(
        NamedEntityGraph(
                name = "profileWithSkills", attributeNodes = [NamedAttributeNode("craftsmanSkills", subgraph = "craftsmanSkillWithAll")],
                subgraphs = [
                    NamedSubgraph(
                            name = "craftsmanSkillWithAll",
                            attributeNodes = [
                                NamedAttributeNode("craftsmanProfile"), NamedAttributeNode("skill", subgraph = "")] )
        ])
)
class CraftsmanProfile : Profile() {

    @OneToMany(mappedBy = "craftsmanProfile", cascade = [CascadeType.ALL], orphanRemoval = true)
    val craftsmanSkills = mutableListOf<CraftsmanSkill>()

    fun addSkill(skill: Skill, level: Level) {
        craftsmanSkills.add(CraftsmanSkill().also {
            it.craftsmanProfile = this
            it.level = level
            it.skill = skill
        })
    }

    //    public List<Skill> getSkills() {
    //        return this.craftsmanSkills
    //                .stream()
    //                .map(CraftsmanSkill::getSkill)
    //                .collect(Collectors.toList());
    //    }

}
