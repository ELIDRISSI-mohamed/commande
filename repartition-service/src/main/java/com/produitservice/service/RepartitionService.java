package com.produitservice.service;


import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Repartition;

import java.util.List;

public interface RepartitionService {
    public Repartition save(Repartition repartition) throws TechnicalException;
    public Repartition update(Repartition repartition) throws TechnicalException;
    public Repartition recherche(String nom) throws TechnicalException;
    public Repartition rechercheById(Long id) throws TechnicalException;
    public void delete(Long id) throws TechnicalException;
    public List<Repartition> all() throws TechnicalException;
}
