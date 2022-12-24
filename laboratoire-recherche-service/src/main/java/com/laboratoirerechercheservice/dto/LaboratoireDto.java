package com.laboratoirerechercheservice.dto;

import com.laboratoirerechercheservice.model.Laboratoire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LaboratoireDto {

    private Long id;
    private String intitule;
    private String acronyme;
    private ProfesseurDto responsable;
    private double budget_annuel;
    private Set<ProfesseurDto> membres;
    private Set<EquipeRechercheDto> equipes;

    public Laboratoire convertToEntity() {
        Laboratoire target = new Laboratoire();
        target.setId(this.getId());
        target.setIntitule(this.getIntitule());
        target.setAcronyme(this.getAcronyme());
        target.setResponsable(this.getResponsable().getId());
        target.setMembres(this.getMembres().stream().map(ProfesseurDto::getId).collect(Collectors.toSet()));
        target.setEquipes(this.getEquipes().stream().map(EquipeRechercheDto::getId).collect(Collectors.toSet()));
        target.setBudget_annuel(this.getBudget_annuel());

        return target;
    }
}
