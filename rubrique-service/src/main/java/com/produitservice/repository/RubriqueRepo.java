package com.produitservice.model.repository;

import com.produitservice.model.Rubrique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RubriqueRepo extends JpaRepository<Rubrique, Long> {
    Rubrique findByNom(String nom);
}
