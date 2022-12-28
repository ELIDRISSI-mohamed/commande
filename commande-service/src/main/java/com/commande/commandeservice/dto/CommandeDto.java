package com.commande.commandeservice.dto;

import com.commande.commandeservice.model.CommandeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.List;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor
public class CommandeDto {
    private Long id;
    private String responsable;
    @ElementCollection
    private List<ProduitDto> produits;
    private Double prixTotal;

    public CommandeModel toEntity(){
        CommandeModel target = new CommandeModel();

        target.setId(this.id);
        target.setResponsable(this.getResponsable());
        target.setProduits(this.getProduits().stream().map(ProduitDto::getId).collect(Collectors.toList()));
        target.setPrixTotal(this.getPrixTotal());

        return target;
    }
}
