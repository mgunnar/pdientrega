package com.matheus.entregapdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class EntregapdiApplication {

    private static final Logger logger = Logger.getLogger(EntregapdiApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(EntregapdiApplication.class, args);
    }
}
