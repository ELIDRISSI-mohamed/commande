package com.commande.commandeservice.dto;


import com.commande.commandeservice.model.ProduitCommande;
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

    public ProduitCommande toProduitCommande(){
        ProduitCommande target = new ProduitCommande();

        target.setId(this.getId());
        target.setNom(this.getNom());
        target.setDescription(this.getDescription());
        target.setPrix(this.getPrix());
        target.setQte(this.getQte());
        target.setQteDemande(this.getQteDemande());
        target.setRubrique(this.getRubrique().getId());

        return target;
    }

}
