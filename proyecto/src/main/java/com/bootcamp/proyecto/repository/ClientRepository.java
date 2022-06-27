package com.bootcamp.proyecto.repository;


import com.bootcamp.proyecto.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, Long> {

}
