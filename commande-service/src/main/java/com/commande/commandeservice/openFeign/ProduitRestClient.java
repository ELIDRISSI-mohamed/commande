package com.commande.commandeservice.openFeign;

import com.commande.commandeservice.dto.ProduitDto;
import com.commande.commandeservice.dto.RubriqueDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "${url-produit-service}", name = "PRODUIT-SERVICE")
public interface ProduitRestClient {
    @GetMapping("/all")
    List<ProduitDto> all();
    @GetMapping("/{id}")
    ProduitDto get(@PathVariable("id") Long id);
}
