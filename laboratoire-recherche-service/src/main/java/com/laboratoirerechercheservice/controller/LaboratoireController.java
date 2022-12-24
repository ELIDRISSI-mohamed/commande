package com.laboratoirerechercheservice.controller;


import com.laboratoirerechercheservice.dto.EquipeRechercheDto;
import com.laboratoirerechercheservice.dto.LaboratoireDto;
import com.laboratoirerechercheservice.dto.ProfesseurDto;
import com.laboratoirerechercheservice.exception.TechnicalException;
import com.laboratoirerechercheservice.model.Laboratoire;
import com.laboratoirerechercheservice.service.LaboratoireService;
import com.laboratoirerechercheservice.service.LaboratoireServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("labo")
public class LaboratoireController {
    LaboratoireService laboratoireService;

    public LaboratoireController(LaboratoireService laboratoireService) {
        this.laboratoireService = laboratoireService;
    }

    @GetMapping("/all")
    List<LaboratoireDto> allLabo(){
        log.info("All labos");
        return laboratoireService.allLabo();
    }
    @GetMapping("/laboById/{id}")
    LaboratoireDto serchLabo(@PathVariable Long id) throws TechnicalException {
        return laboratoireService.serchLabo(id);
    }
    @GetMapping("/laboByIntitule/{intitule}")
    LaboratoireDto serchLabo(@PathVariable String intitule) throws TechnicalException {
        return laboratoireService.serchLabo(intitule);
    }
    @PutMapping("/update")
    LaboratoireDto updateLabo(@RequestBody LaboratoireDto laboratoire) throws TechnicalException {
        return laboratoireService.updateLabo(laboratoire);
    }
    @DeleteMapping("/delete/{id}")
    void deleteLabo(@PathVariable Long id) throws TechnicalException {
        laboratoireService.deleteLabo(id);
    }
    @PostMapping("/add")
    public LaboratoireDto addLabo(@RequestBody LaboratoireDto laboratoireDto) throws TechnicalException {
        return laboratoireService.addLabo(laboratoireDto);
    }
    @GetMapping("/membres/{id}")
    public List<ProfesseurDto> getMembres(@PathVariable Long id) throws TechnicalException {
        return laboratoireService.getMembres(id);
    }
    @GetMapping("/responsable/{id}")
    public ProfesseurDto getResponsable(@PathVariable Long id) throws TechnicalException {
        return laboratoireService.getResponsable(id);
    }
    @GetMapping("/equipes/{id}")
    public List<EquipeRechercheDto> getEquipes(@PathVariable Long id) throws TechnicalException {
        System.out.println(id);
        return laboratoireService.getEquipes(id);
    }
}
