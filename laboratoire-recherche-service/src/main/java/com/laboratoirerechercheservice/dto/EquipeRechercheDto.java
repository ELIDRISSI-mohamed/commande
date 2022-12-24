package com.laboratoirerechercheservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class EquipeRechercheDto {
    private Long id;
    private String nom;
    private String acronyme;
    private ProfesseurDto responsable;
    private List<ProfesseurDto> membres;
    private double budget_annuel;

    public EquipeRechercheDto(Long id){
        this.id = id;
    }

}
