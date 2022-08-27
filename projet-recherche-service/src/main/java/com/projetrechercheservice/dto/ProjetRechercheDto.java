package com.projetrechercheservice.dto;

import com.projetrechercheservice.model.ProjetRecherche;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProjetRechercheDto {
    private Long id;
    private String nom;
    private ProfesseurDto responsable;
    private Set<ProfesseurDto> membres;
    private double budget_annuel;

    public ProjetRecherche ToEntity() {
        ProjetRecherche target = new ProjetRecherche();

        target.setId(this.getId());
        target.setNom(this.getNom());
        target.setResponsable(this.getResponsable().getId());
        target.setMembres(this.getMembres().stream().map(ProfesseurDto::getId).collect(Collectors.toList()));
        target.setBudget_annuel(this.getBudget_annuel());

        return target;
    }
}
