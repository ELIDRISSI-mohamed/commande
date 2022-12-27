package com.commande.commandeservice.repo;

import com.commande.commandeservice.model.CommandeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepo extends JpaRepository<CommandeModel, Long> {
}
