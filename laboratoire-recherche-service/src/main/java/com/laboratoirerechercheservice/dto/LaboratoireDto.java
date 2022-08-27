package com.laboratoirerechercheservice.dto;

import com.laboratoirerechercheservice.model.Laboratoire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaboratoireDto {

    private Long id;
    private String intitule;
    private String acronyme;
    private ProfesseurDto responsable;
    private double budget_annuel;
    private Set<ProfesseurDto> membres;
    private Set<EquipeRecherche> equipe;

    public Laboratoire convertToEntity() {
        Laboratoire target = new Laboratoire();
        target.setId(this.getId());
        target.setIntitule(this.getIntitule());
        target.setAcronyme(this.getAcronyme());
        target.setResponsable(this.getResponsable().getId());
        target.setMembres(this.getMembres().stream().map(ProfesseurDto::getId).collect(Collectors.toSet()));
        target.setEquipe(this.getEquipe().stream().map(EquipeRecherche::getId).collect(Collectors.toSet()));

        return target;
    }
}
