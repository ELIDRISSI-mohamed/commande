package com.professeurservice.service;

import com.professeurservice.entity.Professeur;
import com.professeurservice.exception.ExceptionCode;
import com.professeurservice.exception.TechnicalException;
import com.professeurservice.repository.ProfesseurRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProfesseurServiceImpl implements ProfesseurService {
    private ProfesseurRepo professeurRepo;

    public ProfesseurServiceImpl(ProfesseurRepo professeurRepo) {
        this.professeurRepo = professeurRepo;
    }

    @Override
    public Professeur save(Professeur professeur) {
        log.info("Save Professeur");
        return professeurRepo.save(professeur);
    }

    @Override
    public Professeur search(String nom, String prenom) throws TechnicalException {
        Professeur professeur = professeurRepo.findByNomAndPrenom(nom, prenom);
        if (professeur == null) throw new TechnicalException(ExceptionCode.PROFESSEUR_NOT_EXIST);
        return professeur;
    }

    @Override
    public Optional<Professeur> searchById(Long id) throws TechnicalException {
        Optional<Professeur> professeur = professeurRepo.findById(id);
        if (professeur == null) throw new TechnicalException(ExceptionCode.PROFESSEUR_NOT_EXIST);
        return professeur;
    }

    @Override
    public Professeur update(Professeur professeur) {
        log.info("Update info pro");
        return professeurRepo.save(professeur);
    }

    @Override
    public List<Professeur> allProfesseurs() {
        log.info("Get all professeurs");
        return professeurRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        professeurRepo.deleteById(id);
    }
}
