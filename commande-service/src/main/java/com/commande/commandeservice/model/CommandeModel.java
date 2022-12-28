package com.commande.commandeservice.model;

import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.dto.ProduitDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class CommandeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String responsable;
    @ElementCollection
    private List<Long> produits;
    private Double prixTotal;

    public CommandeDto toDto(){
        CommandeDto target = new CommandeDto();

        target.setId(this.id);
        target.setResponsable(this.getResponsable());
        target.setProduits(this.getProduits().stream().map(item -> new ProduitDto(item)).collect(Collectors.toList()));
        target.setPrixTotal(this.getPrixTotal());

        return target;
    }
}
