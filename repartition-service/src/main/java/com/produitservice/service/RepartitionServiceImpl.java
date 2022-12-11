package com.produitservice.service;

import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Repartition;
import com.produitservice.repository.RepartitionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service @Transactional @Slf4j
public class RepartitionServiceImpl implements RepartitionService {

    private RepartitionRepo repartitionRepo;

    public RepartitionServiceImpl(RepartitionRepo repartitionRepo) {
        this.repartitionRepo = repartitionRepo;
    }

    @Override
    public Repartition save(Repartition rep) throws TechnicalException {
        if (rep.getNom()==null||rep.getIdBudget()==null||rep.getIdStructure()==null||rep.getTypeStructure()==null)  throw new TechnicalException("MESSING PARAMS");
        return repartitionRepo.save(rep);
    }

    @Override
    public Repartition update(Repartition rep) throws TechnicalException {
        Optional<Repartition> repartition = repartitionRepo.findById(rep.getId());
        if(!repartition.isPresent()) throw new TechnicalException("REPARTITION_EXIST");
        return repartitionRepo.save(rep);
    }

    @Override
    public Repartition recherche(String nom) throws TechnicalException {
        Repartition repartition = repartitionRepo.findByNom(nom);
        if(repartition==null) throw new TechnicalException("REPARTITION_NOT_FOUND");
        return repartition;
    }

    @Override
    public Repartition rechercheById(Long id) throws TechnicalException {
        Optional<Repartition> repartition = repartitionRepo.findById(id);
        if(!repartition.isPresent()) throw new TechnicalException("REPARTITION_NOT_FOUND");
        return repartition.get();
    }

    @Override
    public void delete(Long id) throws TechnicalException {
        Optional<Repartition> repartition = repartitionRepo.findById(id);
        if(!repartition.isPresent()) throw new TechnicalException("REPARTITION_NOT_FOUND");
        else repartitionRepo.deleteById(id);
    }

    @Override
    public List<Repartition> all() throws TechnicalException {
        List<Repartition> repartitions = repartitionRepo.findAll();
        if(repartitions==null) throw new TechnicalException("NO_REPARTITION_FOUND");
        return repartitions;
    }
}
