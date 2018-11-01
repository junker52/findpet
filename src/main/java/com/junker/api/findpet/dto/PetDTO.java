package com.junker.api.findpet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PetDTO implements Serializable {

    private String id;

    @NotEmpty(message = "Name can't be null")
    private String name;

    private String race;

    private String species;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
}
