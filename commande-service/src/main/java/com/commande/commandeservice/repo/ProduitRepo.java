package com.commande.commandeservice.repo;

import com.commande.commandeservice.model.CommandeModel;
import com.commande.commandeservice.model.ProduitCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<ProduitCommande, Long> {
}
