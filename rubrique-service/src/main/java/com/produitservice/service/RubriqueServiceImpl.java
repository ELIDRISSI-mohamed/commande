package com.produitservice.service;

import com.produitservice.exception.ExceptionCode;
import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Rubrique;
import com.produitservice.repository.RubriqueRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service @Transactional @Slf4j
public class RubriqueServiceImpl implements RubriqueService {
    RubriqueRepo rubriqueRepo;

    public RubriqueServiceImpl(RubriqueRepo rubriqueRepo) {
        this.rubriqueRepo = rubriqueRepo;
    }

    @Override
    public Rubrique add(Rubrique rubrique) {
        return rubriqueRepo.save(rubrique);
    }
    @Override
    public Rubrique update(Rubrique rubrique) {
        return rubriqueRepo.save(rubrique);
    }
    @Override
    public Rubrique recherche(String nom) throws TechnicalException {
        Rubrique rubrique = rubriqueRepo.findByNom(nom);
        if(rubrique==null) throw new TechnicalException(ExceptionCode.RUBRIQUE_NOT_EXIST);
        else return rubrique;
    }
    @Override
    public Rubrique rechercheById(Long id) throws TechnicalException {
        Optional<Rubrique> rubrique = rubriqueRepo.findById(id);
        if(!rubrique.isPresent()) throw new TechnicalException(ExceptionCode.RUBRIQUE_NOT_EXIST);
        return rubrique.get();
    }
    @Override
    public void delete(Long id) throws TechnicalException {
        Optional<Rubrique> rubrique = rubriqueRepo.findById(id);
        if(!rubrique.isPresent()) throw new TechnicalException(ExceptionCode.RUBRIQUE_NOT_EXIST);
        rubriqueRepo.deleteById(rubrique.get().getId());
    }
    @Override
    public List<Rubrique> all() throws TechnicalException {
        List<Rubrique> rubriques = rubriqueRepo.findAll();
        if(rubriques==null)  throw new TechnicalException(ExceptionCode.NO_RUBRIQUE);
        else return rubriques;
    }
}
