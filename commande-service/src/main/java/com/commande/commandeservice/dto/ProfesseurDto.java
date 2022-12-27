package com.commande.commandeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProfesseurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String mail;

    public ProfesseurDto(Long id) {
        this.id = id;
    }
}
