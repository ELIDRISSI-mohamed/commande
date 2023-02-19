package com.commande.commandeservice.controller;

import com.commande.commandeservice.dto.CommandeDto;
import com.commande.commandeservice.exception.TechnicalException;
import com.commande.commandeservice.service.CommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("commande")
@CrossOrigin("*")
public class CommandeController {
    private CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping()
    CommandeDto add(@RequestBody CommandeDto commande) throws TechnicalException {
        return commandeService.add(commande);
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
    CommandeDto update(@RequestBody CommandeDto commande) throws TechnicalException {
        return commandeService.update(commande);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) throws TechnicalException {
        commandeService.delete(id);
    }
}
