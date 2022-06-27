package com.bootcamp.proyecto.repository;

import com.bootcamp.proyecto.entity.WithdrawalAfp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WithdrawalAfpRepository extends MongoRepository<WithdrawalAfp, Long> {

    WithdrawalAfp save(WithdrawalAfp withdrawalAfp);

}
