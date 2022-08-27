package com.projetrechercheservice.repository;

import com.projetrechercheservice.model.ProjetRecherche;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjetRechercheRepo extends JpaRepository<ProjetRecherche, Long> {
    ProjetRecherche findByNom(String nom);
}
