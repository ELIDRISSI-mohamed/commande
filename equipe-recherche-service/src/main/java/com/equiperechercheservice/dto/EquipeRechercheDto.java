package com.equiperechercheservice.dto;

import com.equiperechercheservice.model.EquipeRecherche;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class EquipeRechercheDto {
    private Long id;
    private String nom;
    private String acronyme;
    private ProfesseurDto responsable;
    private Set<ProfesseurDto> membres;
    private double budget_annuel;

    public EquipeRecherche convertToEntity(){
        EquipeRecherche target = new EquipeRecherche();

        target.setId(this.getId());
        target.setNom(this.getNom());
        target.setAcronyme(this.getAcronyme());
        target.setResponsable(this.getResponsable().getId());
        target.setMembres(this.getMembres().stream().map(ProfesseurDto::getId).collect(Collectors.toSet()));
        target.setBudget_annuel(this.getBudget_annuel());

        return target;
    }

}
