package com.produitservice.service;


import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Rubrique;

import java.util.List;

public interface RubriqueService {
    public Rubrique add(Rubrique rubrique);
    public Rubrique update(Rubrique rubrique);
    public Rubrique recherche(String nom) throws TechnicalException;
    public Rubrique rechercheById(Long id) throws TechnicalException;
    public void delete(Long id) throws TechnicalException;
    public List<Rubrique> all() throws TechnicalException;
}
