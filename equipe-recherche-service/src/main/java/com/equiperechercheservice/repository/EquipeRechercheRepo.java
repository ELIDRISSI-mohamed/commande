package com.equiperechercheservice.repository;

import com.equiperechercheservice.model.EquipeRecherche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface EquipeRechercheRepo extends JpaRepository<EquipeRecherche, Long> {
    EquipeRecherche findByNom(String intitule);
}
