package com.zassyne.userservice.models.entities.profile

import com.zassyne.userservice.models.embeddable.Address
import javax.persistence.*

@Entity(name = "profile")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "profile_type", discriminatorType = DiscriminatorType.STRING)
abstract class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "phoneNumber")
    var phoneNumber: String? = null

    @Embedded
    var address: Address? = null
}
