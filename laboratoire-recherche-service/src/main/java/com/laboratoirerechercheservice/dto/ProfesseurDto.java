package com.laboratoirerechercheservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ProfesseurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;

    public ProfesseurDto(Long id) {
        this.id = id;
    }
}
