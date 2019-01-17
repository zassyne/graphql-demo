package com.zassyne.userservice.models.entities.user

import javax.persistence.*

@Entity(name = "picture")
class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var location: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null
}