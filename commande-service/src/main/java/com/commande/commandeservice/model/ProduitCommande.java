package com.commande.commandeservice.model;


import com.commande.commandeservice.dto.ProduitDto;
import com.commande.commandeservice.dto.RubriqueDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProduitCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String description;
    private Long rubrique;
    private double prix;
    private int qte;
    private int qteDemande;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private CommandeModel commandeModel;

    public ProduitDto toDto(){
        ProduitDto target = new ProduitDto();

        target.setId(this.getId());
        target.setNom(this.getNom());
        target.setDescription(this.getDescription());
        target.setPrix(this.getPrix());
        target.setQte(this.getQte());
        target.setQteDemande(this.getQteDemande());
        target.setRubrique(new RubriqueDto(this.getRubrique()));

        return target;
    }

}
