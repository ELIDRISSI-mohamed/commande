package com.produitservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class RubriqueDto {
    private Long id;
    private String nom;
    private String description;
    private double budget;

    public RubriqueDto(Long id) {
        this.id = id;
    }
}
