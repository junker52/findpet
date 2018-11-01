package com.junker.api.findpet.repository;

import com.junker.api.findpet.domain.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {

    Optional<Pet> findById(String id);

}
