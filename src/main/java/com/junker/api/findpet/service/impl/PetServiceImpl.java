package com.junker.api.findpet.service.impl;

import com.junker.api.findpet.domain.Pet;
import com.junker.api.findpet.repository.PetRepository;
import com.junker.api.findpet.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> getAllPets() {
        return this.petRepository.findAll();
    }
}
