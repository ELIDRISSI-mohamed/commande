package com.professeurservice;

import com.professeurservice.entity.Professeur;
import com.professeurservice.repository.ProfesseurRepo;
import com.professeurservice.service.ProfesseurServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfesseurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfesseurServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProfesseurServiceImpl professeurService) {
        return args -> {
            professeurService.save(new Professeur(null, "idrissi", "mohamed", "idrissi@gmail.com"));
            professeurService.save(new Professeur(null, "idrissi-1", "mohamed-1", "idrissi-1@gmail.com"));
            professeurService.save(new Professeur(null, "idrissi-2", "mohamed-2", "idrissi-2@gmail.com"));
        };
    }

}
