package com.projetrechercheservice.service;


import com.projetrechercheservice.dto.ProfesseurDto;
import com.projetrechercheservice.dto.ProjetRechercheDto;
import com.projetrechercheservice.exception.ExceptionCode;
import com.projetrechercheservice.exception.TechnicalException;
import com.projetrechercheservice.model.ProjetRecherche;
import com.projetrechercheservice.openFeign.ProfesseurRestClient;
import com.projetrechercheservice.repository.ProjetRechercheRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service @Transactional @Slf4j
public class ProjetRechServiceImpl implements ProjetRechService{
    ProjetRechercheRepo projetRechercheRepo;
    ProfesseurRestClient professeurRestClient;

    public ProjetRechServiceImpl(ProjetRechercheRepo projetRechercheRepo, ProfesseurRestClient professeurRestClient) {
        this.projetRechercheRepo = projetRechercheRepo;
        this.professeurRestClient = professeurRestClient;
    }

    @Override
    public ProjetRechercheDto addProjet(ProjetRechercheDto projet) throws TechnicalException {
        log.info("Add Projet Service");
        if (projet.getResponsable()==null||projet.getNom()==null||projet.getMembres()==null)  throw new TechnicalException("MESSING PARAMS");
        return projetRechercheRepo.save(projet.ToEntity()).ToProjetRechercheDto();
    }
    @Override
    public void deleteProjet(Long id) throws TechnicalException {
        Optional<ProjetRecherche> projetRecherche = projetRechercheRepo.findById(id);
        if(projetRecherche.isPresent()) projetRechercheRepo.deleteById(id);
        else throw new TechnicalException(ExceptionCode.PROJET_NOT_FOUND);
    }
    @Override
    public ProjetRechercheDto updateProjet(ProjetRechercheDto projet) throws TechnicalException {
        Optional<ProjetRecherche> projetRecherche = projetRechercheRepo.findById(projet.getId());
        if(projetRecherche.isPresent()) return projetRechercheRepo.save(projet.ToEntity()).ToProjetRechercheDto();
        else throw new TechnicalException(ExceptionCode.PROJET_NOT_FOUND);
    }
    @Override
    public ProjetRechercheDto search(String nom) throws TechnicalException {
        ProjetRecherche projetRecherche = projetRechercheRepo.findByNom(nom);
        if(projetRecherche==null) throw new TechnicalException(ExceptionCode.PROJET_NOT_FOUND);
        else return projetRecherche.ToProjetRechercheDto();
    }
    @Override
    public ProjetRechercheDto searchById(Long id) throws TechnicalException {
        Optional<ProjetRecherche> projetRecherche = projetRechercheRepo.findById(id);
        if(!projetRecherche.isPresent()) throw new TechnicalException(ExceptionCode.PROJET_NOT_FOUND);
        ProjetRechercheDto projetRechercheDto = projetRecherche.get().ToProjetRechercheDto();
        projetRechercheDto.setResponsable(responsableProjet(projetRechercheDto.getId()));
        projetRechercheDto.setMembres(membresProjet(projetRechercheDto.getId()));

        return projetRechercheDto;
    }

    @Override
    public List<ProjetRechercheDto> allProjet() throws TechnicalException {
        List<ProjetRecherche> projetRecherches = projetRechercheRepo.findAll();
        if(projetRecherches==null) throw new TechnicalException(ExceptionCode.PROJET_NOT_FOUND);
        List<ProjetRechercheDto> projetRechercheDtos = projetRecherches.stream().map(pr -> pr.ToProjetRechercheDto()).collect(Collectors.toList());
        List<ProjetRechercheDto> projetRechercheDtos1 = new ArrayList<>();
        for(ProjetRechercheDto projetRechercheDto: projetRechercheDtos){
            projetRechercheDto.setMembres(membresProjet(projetRechercheDto.getId()));
            projetRechercheDto.setResponsable(professeurRestClient.searchProfesseurById(projetRechercheDto.getId()));
            projetRechercheDtos1.add(projetRechercheDto);
        }
        return projetRechercheDtos1;

    }
    @Override
    public ProfesseurDto responsableProjet(Long id) throws TechnicalException {
        Optional<ProjetRecherche> projetRecherche = projetRechercheRepo.findById(id);
        if(projetRecherche.isPresent()) {
            ProfesseurDto p = professeurRestClient.searchProfesseurById(projetRecherche.get().getResponsable());
            return p;
        }
        else throw new TechnicalException(ExceptionCode.PROJET_NOT_FOUND);
    }

    @Override
    public Set<ProfesseurDto> membresProjet(Long id) throws TechnicalException {
        Optional<ProjetRecherche> projetRecherche = projetRechercheRepo.findById(id);
        if(!projetRecherche.isPresent()) throw new TechnicalException(ExceptionCode.PROJET_NOT_FOUND);
        else {
            Set<ProfesseurDto> professeurDtos = projetRecherche.get().getMembres().stream()
                    .map(p-> professeurRestClient.searchProfesseurById(p)).collect(Collectors.toSet());
            return professeurDtos;
        }
    }
}
