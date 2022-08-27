package com.equiperechercheservice.service;

import com.equiperechercheservice.dto.EquipeRechercheDto;
import com.equiperechercheservice.dto.ProfesseurDto;
import com.equiperechercheservice.exception.ExceptionCode;
import com.equiperechercheservice.exception.TechnicalException;
import com.equiperechercheservice.model.EquipeRecherche;
import com.equiperechercheservice.openFeign.ProfesseurRestClient;
import com.equiperechercheservice.repository.EquipeRechercheRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class EquipeRechercheServiceImpl implements EquipeRechercheService {
    EquipeRechercheRepo equipeRechercheRepo;
    ProfesseurRestClient professeurRestClient;

    public EquipeRechercheServiceImpl(EquipeRechercheRepo equipeRechercheRepo, ProfesseurRestClient professeurRestClient) {
        this.equipeRechercheRepo = equipeRechercheRepo;
        this.professeurRestClient = professeurRestClient;
    }

    @Override
    public EquipeRechercheDto addEquipe(EquipeRechercheDto equipeRechercheDto) throws TechnicalException {
        if (equipeRechercheDto.getNom() == null) throw new TechnicalException(ExceptionCode.MISSING_FIELDS);
        else {
            EquipeRecherche equipeRecherche = equipeRechercheDto.convertToEntity();
            return equipeRechercheRepo.save(equipeRecherche).convertToDto();
        }
    }
    @Override
    public List<EquipeRechercheDto> allEquipe() {
        List<EquipeRecherche> equipeRecherches = equipeRechercheRepo.findAll();
        List<EquipeRechercheDto> equipeRechercheDtos = equipeRecherches.stream()
                .map(equipeRecherche -> equipeRecherche.convertToDto()).collect(Collectors.toList());

        return equipeRechercheDtos;
    }
    @Override
    public EquipeRechercheDto serchEquipe(Long id) throws TechnicalException {
        EquipeRecherche equipeRecherche = equipeRechercheRepo.findById(id).get();
        if (equipeRecherche == null) throw new TechnicalException(ExceptionCode.Laboratoire_NOT_EXIST);
        else {
            return equipeRecherche.convertToDto();
        }
    }
    @Override
    public EquipeRechercheDto serchEquipe(String nom) throws TechnicalException {
        EquipeRecherche equipeRecherche = equipeRechercheRepo.findByNom(nom);
        if (equipeRecherche == null) throw new TechnicalException(ExceptionCode.Laboratoire_NOT_EXIST);
        else {
            return equipeRecherche.convertToDto();
        }
    }
    @Override
    public EquipeRechercheDto updateEquipe(EquipeRechercheDto equipeRechercheDto) throws TechnicalException {
        Optional<EquipeRecherche> equipeRecherche = equipeRechercheRepo.findById(equipeRechercheDto.getId());
        if (!equipeRecherche.isPresent()) throw new TechnicalException(ExceptionCode.Laboratoire_NOT_EXIST);
        else {
            return equipeRechercheRepo.save(equipeRechercheDto.convertToEntity()).convertToDto();
        }
    }
    @Override
    public void deleteEquipe(Long id) throws TechnicalException {
        EquipeRecherche equipeRecherche = equipeRechercheRepo.findById(id).get();
        if (equipeRecherche != null) equipeRechercheRepo.deleteById(id);
        else {
            throw new TechnicalException(ExceptionCode.Laboratoire_NOT_EXIST);
        }
    }

    @Override
    public List<ProfesseurDto> getMembres(Long id) throws TechnicalException {
        Optional<EquipeRecherche> equipeRecherche = equipeRechercheRepo.findById(id);
        List<ProfesseurDto> professeurDtos;
        if (!equipeRecherche.isPresent()) throw new TechnicalException(ExceptionCode.Laboratoire_NOT_EXIST);
        else {
            EquipeRechercheDto equipeRechercheDto = equipeRecherche.get().convertToDto();
            professeurDtos = equipeRechercheDto.getMembres().stream()
                    .map(professeurDto -> professeurRestClient.searchProfesseurById(professeurDto.getId())).collect(Collectors.toList());

            return professeurDtos;
        }
    }
    @Override
    public ProfesseurDto getResponsable(Long id) throws TechnicalException {
        EquipeRecherche equipeRecherche = equipeRechercheRepo.findById(id).get();
        ProfesseurDto professeurDto;
        if (equipeRecherche == null) throw new TechnicalException(ExceptionCode.Laboratoire_NOT_EXIST);
        else {
            EquipeRechercheDto equipeRechercheDto = equipeRecherche.convertToDto();
            professeurDto = professeurRestClient.searchProfesseurById(equipeRechercheDto.getResponsable().getId());
            return professeurDto;
        }
    }
}
