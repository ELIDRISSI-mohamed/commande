package com.equiperechercheservice.model;


import com.equiperechercheservice.dto.EquipeRechercheDto;
import com.equiperechercheservice.dto.ProfesseurDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class EquipeRecherche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String acronyme;
    private Long responsable;
    @ElementCollection
    private Set<Long> membres;
    private double budget_annuel;

    public EquipeRechercheDto convertToDto() {
        EquipeRechercheDto target = new EquipeRechercheDto();

        target.setId(this.getId());
        target.setNom(this.getNom());
        target.setAcronyme(this.getAcronyme());
        target.setResponsable(new ProfesseurDto(this.getResponsable()));
        target.setMembres(this.getMembres().stream()
                .map(membre -> new ProfesseurDto(membre)).collect(Collectors.toSet()));
        target.setBudget_annuel(this.getBudget_annuel());

        return target;
    }
}
