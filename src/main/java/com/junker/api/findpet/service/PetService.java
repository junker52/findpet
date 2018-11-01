package com.junker.api.findpet.service;

import com.junker.api.findpet.dto.PetDTO;

import java.util.List;

public interface PetService {
    List<PetDTO> getAllPets();

    PetDTO insertOrUpdatePet(PetDTO petDTO);

    PetDTO getPetById(String id);

    PetDTO updatePetById(PetDTO petDTO, String id);

    PetDTO deleteById(String id);
}
