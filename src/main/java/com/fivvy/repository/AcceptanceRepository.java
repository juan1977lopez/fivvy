package com.fivvy.repository;

import com.fivvy.model.AcceptanceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcceptanceRepository extends MongoRepository<AcceptanceEntity, Long> {

//    List<AcceptanceEntity> findAllById(Optional<Long> id);
    List<AcceptanceEntity> findByUserId(Optional<Long> id);
}
