package com.junker.api.findpet.converter;

import com.junker.api.findpet.domain.Pet;
import com.junker.api.findpet.dto.PetDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetConverter {
    Pet petDTOToPet(PetDTO petDTO);
    PetDTO petToPetDTO(Pet pet);
}
