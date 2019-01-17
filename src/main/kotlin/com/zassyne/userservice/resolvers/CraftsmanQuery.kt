package com.zassyne.userservice.resolvers

import com.zassyne.userservice.models.entities.user.Craftsman
import com.zassyne.userservice.repositories.CraftsmanRepository
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLInputField
import io.leangen.graphql.annotations.GraphQLQuery
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class CraftsmanQuery(
    private val craftsmanRepository: CraftsmanRepository
) {

    @GraphQLQuery(name = "craftsman")
    fun craftsman(@GraphQLArgument(name = "id") id: Long): Craftsman {
        return craftsmanRepository.findById(id).orElseThrow { Exception("User not found") }
    }

    @GraphQLQuery(name = "allCraftsmen")
    fun allCraftsmen(): List<Craftsman> {
        return craftsmanRepository.findAll()
    }

}