package com.professeurservice.service;

import com.professeurservice.dto.ProfResDto;
import com.professeurservice.entity.Professeur;
import com.professeurservice.exception.TechnicalException;

import java.util.List;
import java.util.Optional;

public interface ProfesseurService {
    Professeur save(Professeur professeur);

    Professeur search(String nom, String prenom) throws TechnicalException;

    Professeur searchById(Long id) throws TechnicalException;

    Professeur update(Professeur professeur);

    List<Professeur> allProfesseurs();
    List<ProfResDto> findAllUsernameProfs();
    void delete(Long id);
}
