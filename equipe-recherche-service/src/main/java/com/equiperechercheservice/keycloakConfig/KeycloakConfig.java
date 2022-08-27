package com.equiperechercheservice.keycloakConfig;


import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;

public class KeycloakConfig {

    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}
