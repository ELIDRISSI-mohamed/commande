package com.commande.commandeservice.service;

import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.exception.TechnicalException;

import java.util.List;

public interface CommandeService {
    CommandeDto add(CommandeDto commande) throws TechnicalException;
    List<CommandeDto> all() throws TechnicalException;
    CommandeDto getById(Long id) throws TechnicalException;
    CommandeDto update(CommandeDto CommandeDto) throws TechnicalException;
    void delete(Long id) throws TechnicalException;
}
