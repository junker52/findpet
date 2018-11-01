package com.junker.api.findpet.service.impl;

import com.junker.api.findpet.converter.PetConverter;
import com.junker.api.findpet.domain.Pet;
import com.junker.api.findpet.dto.PetDTO;
import com.junker.api.findpet.repository.PetRepository;
import com.junker.api.findpet.service.PetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    private PetConverter petConverter;


    @Override
    public List<PetDTO> getAllPets() {
        return this.petRepository.findAll()
                .stream()
                .map(petConverter::petToPetDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PetDTO insertOrUpdatePet(PetDTO petDTO) {
        Pet pet = petConverter.petDTOToPet(petDTO);
        pet = this.petRepository.save(pet);
        return this.petConverter.petToPetDTO(pet);
    }

    @Override
    public PetDTO getPetById(String id){
        Pet pet = this.petRepository.findById(id).orElse(null);
        return this.petConverter.petToPetDTO(pet);
    }

    @Override
    public PetDTO updatePetById(PetDTO petDTO, String id) {
        PetDTO db_pet = this.getPetById(id);
        PetDTO createdPet;
        if (db_pet == null) {
            createdPet = this.insertOrUpdatePet(petDTO);
        } else {
            petDTO.setId(id);
            createdPet = this.insertOrUpdatePet(petDTO);
        }
        return createdPet;
    }

    @Override
    public PetDTO deleteById(String id) {
        PetDTO petDTO = this.getPetById(id);
        if (petDTO != null) {
            this.petRepository.deleteById(id);
            return petDTO;
        } else {
            return null;
        }
    }
}
