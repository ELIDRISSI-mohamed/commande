package com.produitservice.service;


import com.produitservice.dto.ProduitDto;
import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Produit;

import java.util.List;

public interface ProduitService {
    public ProduitDto add(ProduitDto produitDto);
    public ProduitDto update(ProduitDto produitDto);
    public ProduitDto recherche(String nom) throws TechnicalException;
    public ProduitDto get(long id) throws Exception;
    public void delete(Long id) throws TechnicalException;
    public List<ProduitDto> all() throws TechnicalException;
}
