package com.zassyne.userservice.repositories;

import com.zassyne.userservice.models.entities.user.Craftsman;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface CraftsmanRepository extends UserRepository<Craftsman> {

    @EntityGraph(value = "craftsmanWithProfile", type = EntityGraph.EntityGraphType.LOAD)
    List<Craftsman> findAll();
}
