package com.commande.commandeservice.service;


import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.exception.ExceptionCode;
import com.commande.commandeservice.exception.TechnicalException;
import com.commande.commandeservice.model.CommandeModel;
import com.commande.commandeservice.model.ProduitCommande;
import com.commande.commandeservice.repo.CommandeRepo;
import com.commande.commandeservice.repo.ProduitRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements CommandeService{
    CommandeRepo commandeRepo;
    ProduitRepo produitRepo;

    public CommandeServiceImpl(CommandeRepo commandeRepo, ProduitRepo produitRepo) {
        this.commandeRepo = commandeRepo;
        this.produitRepo = produitRepo;
    }

    public CommandeDto add(CommandeDto commande) throws TechnicalException {
        CommandeModel commandeModel = commande.toEntity();
        List<ProduitCommande> produits = commandeModel.getProduits();
        commandeModel.setProduits(null);
        commandeModel.setId(null);
        commandeModel.setDate(new Date());
        commandeModel = commandeRepo.save(commandeModel);
        CommandeModel finalCommandeModel = commandeModel;
        produits.forEach(produit -> {
            produit.setId(null);
            produit.setCommandeModel(finalCommandeModel);
        });
        produits = produitRepo.saveAll(produits);
        commandeModel.setProduits(produits);

        return commandeModel.toDto();
    }

    public List<CommandeDto> all() throws TechnicalException {
        List<CommandeModel> commandes = commandeRepo.findAll();
        List<CommandeDto> commandeDtos = commandes.stream().map(c -> c.toDto()).collect(Collectors.toList());
        return commandeDtos;
    }

   public CommandeDto getById(Long id) throws TechnicalException {
        Optional<CommandeModel> commande = commandeRepo.findById(id);
        if(!commande.isPresent()) throw new TechnicalException(ExceptionCode.ITEM_NOT_EXIST);
        return commande.get().toDto();
    }

    public CommandeDto update(CommandeDto commande) throws TechnicalException {
        return commandeRepo.save(commande.toEntity()).toDto();
    }

    public void delete(Long id) throws TechnicalException {
        commandeRepo.deleteById(id);
    }
}
