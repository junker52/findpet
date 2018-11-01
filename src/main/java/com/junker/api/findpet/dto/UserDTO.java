package com.junker.api.findpet.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO implements Serializable {

    private String id;

    @NotEmpty(message = "username can't be empty")
    private String username;

    @NotEmpty(message = "name can't be empty")
    private String name;

    @NotEmpty(message = "lastname1 can't be empty")
    private String lastname1;

    private String lastname2;

    @Email(message = "email pattern incorrect")
    private String email;
}
