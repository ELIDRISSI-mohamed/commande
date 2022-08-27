package com.professeurservice.repository;

import com.professeurservice.entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepo extends JpaRepository<Professeur, Long> {

    Professeur findByNomAndPrenom(String nom, String prenom);
}
