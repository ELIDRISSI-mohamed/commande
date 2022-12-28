package com.produitservice.service;

import com.produitservice.dto.ProduitDto;
import com.produitservice.exception.ExceptionCode;
import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Produit;
import com.produitservice.repository.ProduitRepo;
import com.produitservice.openFeign.RubriqueRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service @Transactional @Slf4j
public class ProduitServiceImpl implements ProduitService {
    ProduitRepo produitRepo;
    RubriqueRestClient rubriqueRestClient;

    public ProduitServiceImpl(ProduitRepo produitRepo, RubriqueRestClient rubriqueRestClient) {
        this.produitRepo = produitRepo;
        this.rubriqueRestClient = rubriqueRestClient;
    }

    @Override
    public ProduitDto add(ProduitDto produitDto) {
        return produitRepo.save(produitDto.toEntity()).toDto();
    }
    @Override
    public ProduitDto update(ProduitDto produitDto) {
        return produitRepo.save(produitDto.toEntity()).toDto();
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
    public ProduitDto get(long id) throws Exception {
        Optional<Produit> produit = produitRepo.findById(id);
        if(!produit.isPresent()) throw new Exception("NO_PRODUCT_FOUND");
        ProduitDto produitDto = produit.get().toDto();
        produitDto.setRubrique(rubriqueRestClient.rechercher(produitDto.getRubrique().getId()));

        return produitDto;
    }

    @Override
    public void delete(Long id) throws TechnicalException {
        Produit produit = produitRepo.findById(id).get();
        if(produit==null) throw new TechnicalException(ExceptionCode.PRODUCT_NOT_EXIST);
        else produitRepo.delete(produit);
    }
    @Override
    public List<ProduitDto> all() throws TechnicalException {
        List<Produit> produits = produitRepo.findAll();
        if(produits==null)  throw new TechnicalException(ExceptionCode.NO_PRODUCT_EXIST);
        List<ProduitDto> produitDtos = produits.stream().map(p->p.toDto()).collect(Collectors.toList());
        List<ProduitDto> produitDtos1 = new ArrayList<>();
        for(ProduitDto produitDto: produitDtos){
            produitDto.setRubrique(rubriqueRestClient.rechercher(produitDto.getRubrique().getId()));
            produitDtos1.add(produitDto);
        }
        return produitDtos1;
    }
}
