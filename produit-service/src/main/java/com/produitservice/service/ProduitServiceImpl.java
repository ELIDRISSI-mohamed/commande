package com.produitservice.service;

import com.produitservice.dto.ProduitDto;
import com.produitservice.exception.ExceptionCode;
import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Produit;
import com.produitservice.model.repository.ProduitRepo;
import com.produitservice.openFeign.RubriqueRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional @Slf4j
public class ProduitServiceImpl implements ProduitService {
    ProduitRepo produitRepo;
    RubriqueRestClient rubriqueRestClient;

    public ProduitServiceImpl(ProduitRepo produitRepo, RubriqueRestClient rubriqueRestClient) {
        this.produitRepo = produitRepo;
        this.rubriqueRestClient = rubriqueRestClient;
    }

    @Override
    public ProduitDto add(Produit produit) {
        return produitRepo.save(produit).toDto();
    }
    @Override
    public ProduitDto update(Produit produit) {
        return produitRepo.save(produit).toDto();
    }
    @Override
    public ProduitDto recherche(String nom) throws TechnicalException {
        Produit produit = produitRepo.findByNom(nom);
        if(produit==null) throw new TechnicalException(ExceptionCode.PRODUCT_NOT_EXIST);
        else {
            ProduitDto produitDto = produit.toDto();
            System.out.println(produitDto);
            produitDto.setRubrique(rubriqueRestClient.rechercher(produit.getId()));
            return produitDto;
        }
    }
    @Override
    public void delete(Long id) throws TechnicalException {
        Produit produit = produitRepo.findById(id).get();
        if(produit==null) throw new TechnicalException(ExceptionCode.PRODUCT_NOT_EXIST);
        else produitRepo.delete(produit);
    }
    @Override
    public List<Produit> all() throws TechnicalException {
        List<Produit> produits = produitRepo.findAll();
        if(produits==null)  throw new TechnicalException(ExceptionCode.NO_PRODUCT_EXIST);
        else return produits;
    }
}
