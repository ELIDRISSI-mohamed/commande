package com.commande.commandeservice.service;

import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.exception.TechnicalException;
import com.commande.commandeservice.model.CommandeModel;
import com.commande.commandeservice.repo.CommandeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements CommandeService{
    private CommandeRepo commandeRepo;

    public CommandeServiceImpl(CommandeRepo commandeRepo) {
        this.commandeRepo = commandeRepo;
    }

    @Override
    public CommandeDto add(CommandeDto commandeDto) throws TechnicalException {
        return commandeRepo.save(commandeDto.toEntity()).toDto();
    }

    @Override
    public List<CommandeDto> all() throws TechnicalException {
        List<CommandeModel> commandes = commandeRepo.findAll();
        List<CommandeDto> commandeDtos = commandes.stream().map(commande -> commande.toDto()).collect(Collectors.toList());

        return commandeDtos;
    }

    @Override
    public CommandeDto getById(Long id) throws TechnicalException {
        Optional<CommandeModel> commande = commandeRepo.findById(id);
        if(!commande.isPresent()) throw new TechnicalException("COMMANDE_NOT_FOUND");
        return commande.get().toDto();
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
