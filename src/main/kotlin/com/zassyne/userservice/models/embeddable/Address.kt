package com.zassyne.userservice.models.embeddable

import java.io.Serializable
import javax.persistence.Embeddable
import javax.validation.constraints.Size

@Embeddable
class Address : Serializable {
    @Size(max = 100)
    var address1: String? = null

    @Size(max = 100)
    var address2: String? = null

    @Size(max = 50)
    var city: String? = null

    @Size(max = 50)
    var region: String? = null

    @Size(max = 6)
    var zipCode: String? = null
}
