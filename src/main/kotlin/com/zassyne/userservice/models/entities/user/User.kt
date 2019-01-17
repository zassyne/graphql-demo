package com.zassyne.userservice.models.entities.user

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.io.Serializable
import javax.persistence.*

@Entity(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
abstract class User : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "email")
    var email: String? = null

    @OneToMany(mappedBy = "user", cascade = [CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE], fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    var pictures = mutableListOf<Picture>()

    fun addPicture(picture: Picture) {
        this.pictures.add(picture)
        picture.user = this
    }
}