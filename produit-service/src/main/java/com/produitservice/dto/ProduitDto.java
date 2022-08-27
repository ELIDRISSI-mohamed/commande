package com.produitservice.dto;

import com.produitservice.model.Produit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProduitDto {
    private Long id;
    private String nom;
    private String description;
    private RubriqueDto rubrique;

    public Produit toEntity() {
        Produit target = new Produit();

        target.setId(this.getId());
        target.setNom(this.getNom());
        target.setDescription(this.getDescription());
        target.setRubrique(this.getRubrique().getId());

        return target;
    }
}
