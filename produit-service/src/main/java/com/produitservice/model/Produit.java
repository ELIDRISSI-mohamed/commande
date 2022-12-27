package com.produitservice.model;


import com.produitservice.dto.ProduitDto;
import com.produitservice.dto.RubriqueDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String description;
    private Long rubrique;
    private double prix;
    private int qte;

    public ProduitDto toDto() {
        ProduitDto target = new ProduitDto();

        target.setId(this.getId());
        target.setNom(this.getNom());
        target.setDescription(this.getDescription());
        target.setRubrique(new RubriqueDto(this.getRubrique()));
        target.setPrix(this.getPrix());
        target.setQte(this.getQte());

        return target;
    }
}
