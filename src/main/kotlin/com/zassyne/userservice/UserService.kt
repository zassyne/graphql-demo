package com.zassyne.userservice

import com.zassyne.userservice.models.embeddable.Address
import com.zassyne.userservice.models.entities.user.Craftsman
import com.zassyne.userservice.models.entities.profile.CraftsmanProfile
import com.zassyne.userservice.models.entities.profile.Level
import com.zassyne.userservice.models.entities.profile.Skill
import com.zassyne.userservice.models.entities.user.Picture
import com.zassyne.userservice.repositories.CraftsmanRepository
import com.zassyne.userservice.repositories.PictureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.transaction.annotation.Transactional

import java.util.*
import javax.persistence.EntityManager

@SpringBootApplication
@Transactional
@Configuration
class UserService(private val craftsmanRepository: CraftsmanRepository,
				  private val pictureRepository: PictureRepository,
				  private val entityManager: EntityManager) {

	@Transactional
	fun initDB() {
		for (i in 1..100) {
			val craftsman = Craftsman()
			craftsman.firstName = "lm3allem#$i"
			craftsman.lastName = "molchi#$i"
			craftsman.email = "lm3allem#$i@molchi.com"

			val craftsmanProfile = CraftsmanProfile()

			val skill = Skill()
			skill.name = ("java")
			craftsmanProfile.addSkill(skill, Level.INTERMEDIATE)
			craftsmanProfile.phoneNumber = Random().nextInt(100000000).toString()
			skill.description = "A Good programming language"

			craftsman.craftsmanProfile = craftsmanProfile

			val picture = Picture()
			picture.location = "/pictures/$i/"

			val address = Address()
			address.city = "City$i"
			address.region = "Region$i"
			address.address1 = "Address$i"

			craftsmanProfile.address = address

			craftsman.addPicture(picture)
			craftsmanRepository.save(craftsman)
		}
	}

	@Bean
	fun commandLineRunner(@Autowired craftsmanRepository: CraftsmanRepository) : CommandLineRunner {
		return CommandLineRunner {
			initDB()
		}
	}
}

fun main(args: Array<String>) {
	runApplication<UserService>(*args)
}
