package com.junker.api.findpet.controller;

import com.junker.api.findpet.constants.UrlRoutesConstants;
import com.junker.api.findpet.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UrlRoutesConstants.API_PREFIX + UrlRoutesConstants.PET_PREFIX)
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity getAllPets(){
        return ResponseEntity.ok(this.petService.getAllPets());
    }
}
