package com.laboratoirerechercheservice.config;


import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;

public class KeycloakConfig {

    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}
