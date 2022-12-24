package com.laboratoirerechercheservice.model;

import com.laboratoirerechercheservice.dto.EquipeRechercheDto;
import com.laboratoirerechercheservice.dto.LaboratoireDto;
import com.laboratoirerechercheservice.dto.ProfesseurDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Laboratoire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String intitule;
    private String acronyme;
    private Long responsable;
    @ElementCollection
    private Set<Long> membres;
    private double budget_annuel;
    @ElementCollection
    private Set<Long> equipes;

    public LaboratoireDto convertToDto() {
        LaboratoireDto target = new LaboratoireDto();

        target.setId(this.getId());
        target.setIntitule(this.getIntitule());
        target.setAcronyme(this.getAcronyme());
        target.setBudget_annuel(this.getBudget_annuel());
        target.setResponsable(new ProfesseurDto(this.getResponsable()));
        target.setMembres(this.getMembres().stream()
                .map(item -> new ProfesseurDto(item))
                .collect(Collectors.toSet())
        );
        target.setEquipes(this.getEquipes().stream()
                .map(item -> new EquipeRechercheDto(item))
                .collect(Collectors.toSet())
        );
        return target;
    }
}
