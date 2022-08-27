package com.projetrechercheservice.controller;

import com.projetrechercheservice.dto.ProfesseurDto;
import com.projetrechercheservice.dto.ProjetRechercheDto;
import com.projetrechercheservice.exception.TechnicalException;
import com.projetrechercheservice.model.ProjetRecherche;
import com.projetrechercheservice.service.ProjetRechService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j
@RequestMapping("projet")
public class ProjetRechController {
    ProjetRechService projetRechService;

    public ProjetRechController(ProjetRechService projetRechService) {
        this.projetRechService = projetRechService;
    }

    @PostMapping("/add")
    ProjetRechercheDto addProjet(@RequestBody ProjetRechercheDto projet) throws TechnicalException {
        log.info("Add Projet");
        return projetRechService.addProjet(projet);
    }
    @DeleteMapping("/delete/{id}")
    void deleteProjet(@PathVariable Long id) throws TechnicalException {
        projetRechService.deleteProjet(id);
    }
    @PutMapping("/update")
    ProjetRechercheDto updateProjet(@RequestBody ProjetRechercheDto projet) throws TechnicalException {
        return projetRechService.updateProjet(projet);
    }
    @GetMapping("/getProjetByNom/{nom}")
    ProjetRechercheDto search(@PathVariable String nom) throws TechnicalException {
        return projetRechService.search(nom);
    }
    @GetMapping("/getProjet/{id}")
    ProjetRechercheDto search(@PathVariable Long id) throws TechnicalException {
        return projetRechService.searchById(id);
    }
    @GetMapping("/allProjet")
    List<ProjetRechercheDto> allProjet() throws TechnicalException {
        return projetRechService.allProjet();
    }
    @GetMapping("/responsable/{id}")
    ProfesseurDto responsableProjet(@PathVariable Long id) throws TechnicalException {
        return projetRechService.responsableProjet(id);
    }
    @GetMapping("/membres/{id}")
    List<ProfesseurDto> membresProjet(@PathVariable Long id) throws TechnicalException {
        return projetRechService.membresProjet(id);
    }
}
