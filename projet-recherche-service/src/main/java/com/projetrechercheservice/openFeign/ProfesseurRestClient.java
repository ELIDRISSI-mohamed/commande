package com.projetrechercheservice.openFeign;

import com.projetrechercheservice.dto.ProfesseurDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(url = "${url-professeur-service}", name = "PROJET-RECH-SERVICE")
public interface ProfesseurRestClient {
    @GetMapping("/all")
    List<ProfesseurDto> all();
    @GetMapping("/getProfesseurById/{id}")
    ProfesseurDto searchProfesseurById(@PathVariable Long id);
}
