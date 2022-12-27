package com.produitservice.controller;


import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Rubrique;
import com.produitservice.service.RubriqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j
@RequestMapping("rubrique")
@CrossOrigin("*")
public class RubriqueController {
    RubriqueService rubriqueService;

    public RubriqueController(RubriqueService rubriqueService) {
        this.rubriqueService = rubriqueService;
    }

    @PostMapping("/add")
    public Rubrique add(@RequestBody Rubrique rubrique) {
        return rubriqueService.add(rubrique);
    }
    @PutMapping("/update")
    public Rubrique update(@RequestBody Rubrique rubrique) {
        return rubriqueService.update(rubrique);
    }
    @GetMapping("/{nom}")
    public Rubrique recherche(@PathVariable String nom) throws TechnicalException {
        return rubriqueService.recherche(nom);
    }
    @GetMapping("/rechercheById/{id}")
    public Rubrique rechercheById(@PathVariable Long id) throws TechnicalException {
        return rubriqueService.rechercheById(id);
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws TechnicalException {
        rubriqueService.delete(id);
    }
    @GetMapping("/all")
    public List<Rubrique> all() throws TechnicalException {
        return rubriqueService.all();
    }

}

