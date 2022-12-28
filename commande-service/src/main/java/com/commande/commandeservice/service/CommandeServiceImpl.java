package com.commande.commandeservice.service;

import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.dto.ProduitDto;
import com.commande.commandeservice.exception.TechnicalException;
import com.commande.commandeservice.model.CommandeModel;
import com.commande.commandeservice.openFeign.ProduitRestClient;
import com.commande.commandeservice.repo.CommandeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements CommandeService{
    private CommandeRepo commandeRepo;
    private ProduitRestClient produitRestClient;

    public CommandeServiceImpl(CommandeRepo commandeRepo, ProduitRestClient produitRestClient) {
        this.commandeRepo = commandeRepo;
        this.produitRestClient = produitRestClient;
    }

    @Override
    public CommandeDto add(CommandeDto commandeDto) throws TechnicalException {
        return commandeRepo.save(commandeDto.toEntity()).toDto();
    }

    @Override
    public List<CommandeDto> all() throws TechnicalException {
        List<CommandeModel> commandes = commandeRepo.findAll();
        List<CommandeDto> commandeDtos = commandes.stream().map(commande -> commande.toDto()).collect(Collectors.toList());
        for(CommandeDto commandeDto: commandeDtos){
            commandeDto.setProduits(commandeDto.getProduits().stream().map(item -> produitRestClient.get(item.getId())).collect(Collectors.toList()));

        }

        return commandeDtos;
    }

    @Override
    public CommandeDto getById(Long id) throws TechnicalException {
        Optional<CommandeModel> commande = commandeRepo.findById(id);
        if(!commande.isPresent()) throw new TechnicalException("COMMANDE_NOT_FOUND");
        CommandeDto commandeDto = commande.get().toDto();
        commandeDto.setProduits(commandeDto.getProduits().stream().map(item -> produitRestClient.get(item.getId())).collect(Collectors.toList()));
        return commandeDto;
    }

    @Override
    public CommandeDto update(CommandeDto commandeDto) throws TechnicalException {
        return commandeRepo.save(commandeDto.toEntity()).toDto();
    }

    @Override
    public void delete(Long id) throws TechnicalException {
        commandeRepo.deleteById(id);
    }
}
