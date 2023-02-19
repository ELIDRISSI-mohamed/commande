package com.commande.commandeservice.model;

import com.commande.commandeservice.dto.CommandeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class CommandeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String responsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandeModel")
    private List<ProduitCommande> produits;
    private Double prixTotal;
    private Date date;

    public CommandeDto toDto(){
        CommandeDto target = new CommandeDto();

        target.setId(this.id);
        target.setResponsable(this.getResponsable());
        target.setProduits(this.getProduits().stream().map(item -> item.toDto()).collect(Collectors.toList()));
        target.setPrixTotal(this.getPrixTotal());
        target.setDate(this.getDate());

        return target;
    }
}
