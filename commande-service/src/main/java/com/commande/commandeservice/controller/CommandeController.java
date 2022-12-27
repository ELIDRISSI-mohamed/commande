package com.commande.commandeservice.controller;

import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.exception.TechnicalException;
import com.commande.commandeservice.service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commande")
public class CommandeController {
    private CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping()
    CommandeDto add(@RequestBody CommandeDto commandeDto) throws TechnicalException {
        return commandeService.add(commandeDto);
    }
    @GetMapping()
    List<CommandeDto> all() throws TechnicalException {
        return commandeService.all();
    }
    @GetMapping("/{id}")
    CommandeDto getById(@PathVariable Long id) throws TechnicalException {
        return commandeService.getById(id);
    }
    @PutMapping()
    CommandeDto update(@RequestBody CommandeDto commandeDto) throws TechnicalException {
        return commandeService.update(commandeDto);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) throws TechnicalException {
        commandeService.delete(id);
    }
}
