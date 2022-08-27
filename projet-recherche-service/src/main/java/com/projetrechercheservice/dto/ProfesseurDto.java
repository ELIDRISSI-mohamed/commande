package com.projetrechercheservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProfesseurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String mail;

    public ProfesseurDto(Long id) {
        this.id = id;
    }
}
