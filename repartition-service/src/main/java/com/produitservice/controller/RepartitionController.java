package com.produitservice.controller;


import com.produitservice.exception.TechnicalException;
import com.produitservice.model.Repartition;
import com.produitservice.service.RepartitionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController @Slf4j
@RequestMapping("repartitions")
public class RepartitionController {
    private RepartitionService repartitionService;

    public RepartitionController(RepartitionService repartitionService) {
        this.repartitionService = repartitionService;
    }

    @PostMapping()
    public Repartition save(@RequestBody Repartition repartition) throws TechnicalException {
        return repartitionService.save(repartition);
    }
    @PutMapping()
    public Repartition update(@RequestBody Repartition repartition) throws TechnicalException {
        return repartitionService.update(repartition);
    }
    @GetMapping("getByNom/{nom}")
    public Repartition recherche(@PathVariable String nom) throws TechnicalException {
        return repartitionService.recherche(nom);
    }
    @GetMapping("{id}")
    public Repartition rechercheById(@PathVariable Long id) throws TechnicalException {
        return repartitionService.rechercheById(id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws TechnicalException {
        repartitionService.delete(id);
    }
    @GetMapping()
    public List<Repartition> all() throws TechnicalException {
        return repartitionService.all();
    }
}

