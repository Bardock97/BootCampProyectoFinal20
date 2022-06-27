package com.bootcamp.proyecto.repository;

import com.bootcamp.proyecto.entity.AFP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AfpRepository extends MongoRepository<AFP, Long> {

}
