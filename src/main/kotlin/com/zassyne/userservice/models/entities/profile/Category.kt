package com.zassyne.userservice.models.entities.profile

import javax.persistence.*

@Entity(name = "category")
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column
    private val name: String? = null

    @Column
    private val description: String? = null
}