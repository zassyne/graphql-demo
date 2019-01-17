package com.zassyne.userservice.models.entities.profile

import javax.persistence.*

@Entity(name = "category")
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    val name: String? = null

    @Column
    val description: String? = null
}