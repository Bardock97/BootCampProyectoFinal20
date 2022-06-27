package com.bootcamp.proyecto.repository;

import com.bootcamp.proyecto.entity.Association;
import com.bootcamp.proyecto.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssociationRepository extends MongoRepository<Association, Long> {
    Boolean existsByClient(Client client);
}
