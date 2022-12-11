package com.budgetservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String description;
    private double budget;
}
