package com.fivvy.repository;

import com.fivvy.model.DisclaimerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisclaimerRepository extends MongoRepository<DisclaimerEntity, Long> {

    Optional<DisclaimerEntity> findDisclaimerById(Long id);
}
