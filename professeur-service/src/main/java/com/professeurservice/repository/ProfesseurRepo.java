package com.professeurservice.repository;

import com.professeurservice.entity.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesseurRepo extends JpaRepository<Professeur, Long> {
    /*@Query("SELECT new com.professeurservice.entity.UsernameProfs(id, CONCAT(nom,' ',prenom)) as username FROM Professeur")
    List<UsernameProfs> findAllUsernameProfs();*/
    Professeur findByNomAndPrenom(String nom, String prenom);
}
