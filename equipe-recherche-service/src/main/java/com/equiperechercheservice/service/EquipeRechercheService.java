package com.equiperechercheservice.service;

import com.equiperechercheservice.dto.EquipeRechercheDto;
import com.equiperechercheservice.dto.ProfesseurDto;
import com.equiperechercheservice.exception.TechnicalException;

import java.util.List;
import java.util.Set;

public interface EquipeRechercheService {
    EquipeRechercheDto addEquipe(EquipeRechercheDto equipeRechercheDto) throws TechnicalException;
    List<EquipeRechercheDto> allEquipe() throws TechnicalException;
    EquipeRechercheDto serchEquipe(Long id) throws TechnicalException;
    EquipeRechercheDto serchEquipe(String intitule) throws TechnicalException;
    EquipeRechercheDto updateEquipe(EquipeRechercheDto equipeRechercheDto) throws TechnicalException;
    void deleteEquipe(Long id) throws TechnicalException;
    Set<ProfesseurDto> getMembres(Long id) throws TechnicalException;
    ProfesseurDto getResponsable(Long id) throws TechnicalException;
}
