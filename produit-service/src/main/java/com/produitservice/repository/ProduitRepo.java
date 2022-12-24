package com.produitservice.repository;

import com.produitservice.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProduitRepo extends JpaRepository<Produit, Long> {
    Produit findByNom(String nom);
}
