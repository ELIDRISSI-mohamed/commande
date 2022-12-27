package com.commande.commandeservice.model;

import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.dto.ProduitDto;
import com.commande.commandeservice.dto.ProfesseurDto;
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
    private Long professeur;
    @ElementCollection
    private List<Long> produits;
    private Double prixTotale;

    public CommandeDto toDto(){
        CommandeDto target = new CommandeDto();

        target.setId(this.id);
        target.setProfesseur(new ProfesseurDto(this.getProfesseur()));
        target.setProduits(this.getProduits().stream().map(item -> new ProduitDto(item)).collect(Collectors.toList()));
        target.setPrixTotale(this.getPrixTotale());

        return target;
    }
}
