package com.laboratoirerechercheservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class EquipeRecherche {
    private Long id;
    private String nom;
    private String acronyme;
    private Long responsable;
    private List<Long> membres;
    private double budget_annuel;

    public EquipeRecherche(Long id){
        this.id = id;
    }

}
