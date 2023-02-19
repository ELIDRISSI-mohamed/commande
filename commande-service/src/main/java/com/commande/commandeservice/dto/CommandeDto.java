package com.commande.commandeservice.dto;

import com.commande.commandeservice.model.CommandeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommandeDto {
    private Long id;
    private String responsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandeModel")
    private List<ProduitDto> produits;
    private Double prixTotal;
    private Date date;

    public CommandeModel toEntity(){
        CommandeModel target = new CommandeModel();

        target.setId(this.id);
        target.setResponsable(this.getResponsable());
        target.setProduits(this.getProduits().stream().map(p-> p.toProduitCommande()).collect(Collectors.toList()));
        target.setPrixTotal(this.getPrixTotal());
        target.setDate(this.getDate());

        return target;
    }
}

