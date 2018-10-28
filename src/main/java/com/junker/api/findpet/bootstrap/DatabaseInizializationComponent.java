package com.junker.api.findpet.bootstrap;

import com.junker.api.findpet.domain.Pet;
import com.junker.api.findpet.domain.User;
import com.junker.api.findpet.repository.PetRepository;
import com.junker.api.findpet.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;

@Configuration
@Profile("dev")
public class DatabaseInizializationComponent implements CommandLineRunner {

    private UserRepository userRepository;

    private PetRepository petRepository;

    private MongoTemplate mongoTemplate;

    public DatabaseInizializationComponent(UserRepository userRepository, PetRepository petRepository, MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.petRepository = petRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        this.mongoTemplate.getDb().drop();

        User usuario = User.builder()
                .username("juanGarcia")
                .password("pass123")
                .name("Juan")
                .lastname1("Garcia")
                .lastname2("Flajon")
                .email("wasabi@yopmail.com")
                .build();

        this.userRepository.save(usuario);

        Pet perro = Pet.builder()
                .birthDate(LocalDate.now())
                .name("Boss")
                .race("Beauceron")
                .species("Cannus vulgaris")
                .owner(usuario)
                .build();

        this.petRepository.save(perro);

        perro = Pet.builder()
                .birthDate(LocalDate.now())
                .name("Xira")
                .race("Bordier Colie")
                .species("Cannus vulgaris")
                .owner(usuario)
                .build();

        this.petRepository.save(perro);





    }
}
