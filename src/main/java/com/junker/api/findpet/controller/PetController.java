package com.junker.api.findpet.controller;

import com.junker.api.findpet.constants.UrlRoutesConstants;
import com.junker.api.findpet.dto.PetDTO;
import com.junker.api.findpet.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(UrlRoutesConstants.API_PREFIX + UrlRoutesConstants.PET_PREFIX)
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity getAllPets(){
        List<PetDTO> pets = this.petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    public ResponseEntity insertNewPet(@RequestBody @Valid PetDTO petDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.petService.insertOrUpdatePet(petDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity getPetById(@PathVariable String id){
        PetDTO petDTO = this.petService.getPetById(id);
        if (petDTO != null) {
            return ResponseEntity.ok(petDTO);
        } else {
            //TODO: Implement Error details class;
            return ResponseEntity.badRequest().body("Pet not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePetWithId(@PathVariable String id, @RequestBody @Valid PetDTO petDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.petService.updatePetById(petDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        PetDTO deletedPet = this.petService.deleteById(id);
        if (deletedPet != null) {
            return ResponseEntity.ok(deletedPet);
        } else {
            //TODO: Implement Error details class;
            return ResponseEntity.badRequest().body("Pet to delete not found");
        }
    }
}
