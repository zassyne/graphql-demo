package com.zassyne.userservice.models.entities.user

import com.zassyne.userservice.models.entities.profile.CraftsmanProfile
import javax.persistence.*

@Entity
@DiscriminatorValue(value = "CRAFTSMAN_USER")
class Craftsman : User() {

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var craftsmanProfile: CraftsmanProfile? = null
}
