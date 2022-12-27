package com.professeurservice.controller;

import com.professeurservice.dto.ProfResDto;
import com.professeurservice.entity.Professeur;
import com.professeurservice.exception.TechnicalException;
import com.professeurservice.service.ProfesseurServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@CrossOrigin("*")
@RequestMapping("/professeur")
public class ProfesseurController {
    private ProfesseurServiceImpl professeurService;

    public ProfesseurController(ProfesseurServiceImpl professeurService) {
        this.professeurService = professeurService;
    }

    @PostMapping("/save")
    public Professeur save(@RequestBody Professeur professeur) {
        return professeurService.save(professeur);
    }

    @PutMapping("/update")
    public Professeur update(@RequestBody Professeur professeur) {
        return professeurService.update(professeur);
    }

    @GetMapping("/all")
    public List<Professeur> all() {
        return professeurService.allProfesseurs();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        professeurService.delete(id);
    }

    @PostMapping("/getProfesseurByname")
    public Professeur searchProfesseur(@RequestBody Username username) throws TechnicalException {
        return professeurService.search(username.getNom(), username.getPrenom());
    }

    @GetMapping("/getProfesseurById/{id}")
    public Professeur searchProfesseurById(@PathVariable Long id) throws TechnicalException {
        return professeurService.searchById(id);
    }

    @GetMapping("/getUsernameProfs")
    public List<ProfResDto> getUsernameProfs() {
        return professeurService.findAllUsernameProfs();
    }
}

@Data
@AllArgsConstructor
class Username {
    private String nom;
    private String prenom;
}
