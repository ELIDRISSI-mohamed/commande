package com.projetrechercheservice.service;


import com.projetrechercheservice.dto.ProfesseurDto;
import com.projetrechercheservice.dto.ProjetRechercheDto;
import com.projetrechercheservice.exception.TechnicalException;

import java.util.List;

public interface ProjetRechService {
    ProjetRechercheDto addProjet(ProjetRechercheDto projet) throws TechnicalException;
    void deleteProjet(Long id) throws TechnicalException;
    ProjetRechercheDto updateProjet(ProjetRechercheDto projet) throws TechnicalException;
    ProjetRechercheDto search(String nom) throws TechnicalException;
    ProjetRechercheDto searchById(Long id) throws TechnicalException;
    List<ProjetRechercheDto> allProjet() throws TechnicalException;
    ProfesseurDto responsableProjet(Long id) throws TechnicalException;
    List<ProfesseurDto> membresProjet(Long id) throws TechnicalException;
}
