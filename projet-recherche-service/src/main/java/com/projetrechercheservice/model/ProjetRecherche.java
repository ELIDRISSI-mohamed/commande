package com.projetrechercheservice.model;


import com.projetrechercheservice.dto.ProfesseurDto;
import com.projetrechercheservice.dto.ProjetRechercheDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProjetRecherche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nom;
    private Long responsable;
    @ElementCollection
    private List<Long> membres;
    private double budget_annuel;

    public ProjetRechercheDto ToProjetRechercheDto() {
        ProjetRechercheDto target = new ProjetRechercheDto();

        target.setId(this.getId());
        target.setNom(this.getNom());
        target.setResponsable(new ProfesseurDto(this.getResponsable()));
        target.setMembres(this.getMembres().stream().map(item -> new ProfesseurDto(item)).collect(Collectors.toSet()));
        target.setBudget_annuel(this.getBudget_annuel());

        return target;
    }

}
