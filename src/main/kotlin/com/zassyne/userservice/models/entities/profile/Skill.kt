package com.zassyne.userservice.models.entities.profile

import com.zassyne.userservice.models.entities.user.CraftsmanSkill
import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Immutable
import javax.persistence.*

@Entity(name = "skill")
@Immutable
class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    var name: String? = null

    @Column
    var description: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    var category: Category? = null

    @JsonIgnore
    @OneToMany(mappedBy = "skill")
    var craftsmen = mutableListOf<CraftsmanSkill>()
}
