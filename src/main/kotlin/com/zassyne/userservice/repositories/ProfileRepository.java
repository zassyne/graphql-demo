package com.zassyne.userservice.repositories;

import com.zassyne.userservice.models.entities.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProfileRepository<T extends Profile> extends JpaRepository<T, Long> {

}
