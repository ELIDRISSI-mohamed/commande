package com.laboratoirerechercheservice.repository;

import com.laboratoirerechercheservice.model.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface LaboratoireRepo extends JpaRepository<Laboratoire, Long> {
    Optional<Laboratoire> findByIntitule(String intitule);
}
