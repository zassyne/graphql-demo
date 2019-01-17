package com.zassyne.userservice.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.zassyne.userservice.models.Student
import com.zassyne.userservice.models.entities.profile.CraftsmanProfile
import com.zassyne.userservice.models.entities.user.Client
import com.zassyne.userservice.models.entities.user.Craftsman
import com.zassyne.userservice.models.entities.user.User
import com.zassyne.userservice.repositories.CraftsmanRepository
import com.zassyne.userservice.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class RootQueries(private val craftsmanRepository: CraftsmanRepository): GraphQLQueryResolver {

    fun getStudents(): List<Student> {
        return listOf(
                Student("Yassine", "Zarir", "1234"),
                Student("Elwalid", "Zarir", "4335")
        )
    }

    fun getAllCraftsmen(): List<Craftsman> {
        return craftsmanRepository.findAll()
    }

}