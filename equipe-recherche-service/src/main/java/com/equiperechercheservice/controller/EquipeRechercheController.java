package com.equiperechercheservice.controller;

import com.equiperechercheservice.dto.EquipeRechercheDto;
import com.equiperechercheservice.dto.ProfesseurDto;
import com.equiperechercheservice.exception.TechnicalException;
import com.equiperechercheservice.service.EquipeRechercheService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("equipe")
@CrossOrigin("*")
public class EquipeRechercheController {
    EquipeRechercheService equipeRechercheService;

    public EquipeRechercheController(EquipeRechercheService equipeRechercheService) {
        this.equipeRechercheService = equipeRechercheService;
    }

    @PostMapping("/add")
    EquipeRechercheDto addEquipe(@RequestBody EquipeRechercheDto equipeRechercheDto) throws TechnicalException {
        return equipeRechercheService.addEquipe(equipeRechercheDto);
    }
    @GetMapping("/all")
    List<EquipeRechercheDto> allLabo() throws TechnicalException {
        return equipeRechercheService.allEquipe();
    }
    @GetMapping("/serchEquipe/{id}")
    EquipeRechercheDto serchEquipe(@PathVariable Long id) throws TechnicalException {
        return equipeRechercheService.serchEquipe(id);
    }
    @GetMapping("/serchEquipeByNom/{nom}")
    EquipeRechercheDto serchEquipe(@PathVariable String nom) throws TechnicalException {
        return equipeRechercheService.serchEquipe(nom);
    }
    @PutMapping("/update")
    EquipeRechercheDto updateEquipe(@RequestBody EquipeRechercheDto equipeRechercheDto) throws TechnicalException {
        return equipeRechercheService.updateEquipe(equipeRechercheDto);
    }
    @DeleteMapping("/delete/{id}")
    void deleteEquipe(@PathVariable Long id) throws TechnicalException {
        equipeRechercheService.deleteEquipe(id);
    }
    @GetMapping("/membres/{id}")
    Set<ProfesseurDto> getMembres(@PathVariable Long id) throws TechnicalException {
        return equipeRechercheService.getMembres(id);
    }
    @GetMapping("/responsable/{id}")
    ProfesseurDto getResponsable(@PathVariable Long id) throws TechnicalException {
        return equipeRechercheService.getResponsable(id);
    }
}
