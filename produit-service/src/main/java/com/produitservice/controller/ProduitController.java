package com.produitservice.controller;


import com.produitservice.dto.ProduitDto;
import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Produit;
import com.produitservice.service.ProduitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j
@RequestMapping("produit")
@CrossOrigin("*")
public class ProduitController {
    ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("/add")
    public ProduitDto add(@RequestBody ProduitDto produitDto) {
        return produitService.add(produitDto);
    }
    @PutMapping("/update")
    public ProduitDto update(@RequestBody ProduitDto produitDto) {
        return produitService.update(produitDto);
    }
    @GetMapping("/{nom}")
    public ProduitDto recherche(@PathVariable String nom) throws TechnicalException {
        return produitService.recherche(nom);
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws TechnicalException {
        produitService.delete(id);
    }
    @GetMapping("/all")
    public List<Produit> all() throws TechnicalException {
        return produitService.all();
    }

}

