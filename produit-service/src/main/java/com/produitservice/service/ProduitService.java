package com.produitservice.service;


import com.produitservice.dto.ProduitDto;
import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Produit;

import java.util.List;

public interface ProduitService {
    public ProduitDto add(Produit produit);
    public ProduitDto update(Produit produit);
    public ProduitDto recherche(String nom) throws TechnicalException;
    public void delete(Long id) throws TechnicalException;
    public List<Produit> all() throws TechnicalException;
}
