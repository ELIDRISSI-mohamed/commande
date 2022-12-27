package com.commande.commandeservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProduitDto {
    private Long id;
    private String nom;
    private String description;
    private RubriqueDto rubrique;
    private double prix;
    private int qte;
    private int qteDemande;

    public ProduitDto(Long id) {
        this.id = id;
    }
}
