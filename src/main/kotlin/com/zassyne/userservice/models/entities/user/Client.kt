package com.zassyne.userservice.models.entities.user

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue(value = "CLIENT_USER")
class Client : User()
