package com.junker.api.findpet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "username can't be empty")
    private String username;

    @NotEmpty(message = "password can't be empty")
    private String password;

    @NotEmpty(message = "name can't be empty")
    private String name;

    @NotEmpty(message = "lastname1 can't be empty")
    private String lastname1;

    private String lastname2;

    @Indexed(unique = true)
    @Email(message = "email pattern incorrect")
    private String email;
}
