package com.produitservice.repository;

import com.produitservice.model.Repartition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepartitionRepo extends JpaRepository<Repartition, Long> {
    Repartition findByNom(String nom);
}
