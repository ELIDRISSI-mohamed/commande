package com.commande.commandeservice.service;

import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.exception.TechnicalException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public interface CommandeService {
    CommandeDto add(CommandeDto commandeDto) throws TechnicalException;
    List<CommandeDto> all() throws TechnicalException;
    CommandeDto getById(Long id) throws TechnicalException;
    CommandeDto update(CommandeDto commandeDto) throws TechnicalException;
    void delete(Long id) throws TechnicalException;
}
