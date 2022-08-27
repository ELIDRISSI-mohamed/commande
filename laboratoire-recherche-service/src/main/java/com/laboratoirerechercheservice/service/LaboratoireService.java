package com.laboratoirerechercheservice.service;

import com.laboratoirerechercheservice.dto.LaboratoireDto;
import com.laboratoirerechercheservice.dto.ProfesseurDto;
import com.laboratoirerechercheservice.exception.TechnicalException;
import com.laboratoirerechercheservice.model.Laboratoire;

import java.util.List;

public interface LaboratoireService {
    LaboratoireDto addLabo(LaboratoireDto laboratoireDto) throws TechnicalException;
    List<LaboratoireDto> allLabo();
    LaboratoireDto serchLabo(Long id) throws TechnicalException;
    LaboratoireDto serchLabo(String intitule) throws TechnicalException;
    LaboratoireDto updateLabo(LaboratoireDto laboratoire) throws TechnicalException;
    void deleteLabo(Long id) throws TechnicalException;
    List<ProfesseurDto> getMembres(Long id) throws TechnicalException;
    ProfesseurDto getResponsable(Long id) throws TechnicalException;
}
