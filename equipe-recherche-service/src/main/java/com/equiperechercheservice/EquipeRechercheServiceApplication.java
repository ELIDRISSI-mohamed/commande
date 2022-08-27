package com.equiperechercheservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EquipeRechercheServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipeRechercheServiceApplication.class, args);
    }

}
