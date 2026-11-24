package com.example.prueba_tecnica_novatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.example.prueba_tecnica_novatec", "card", "product"
})
@EntityScan(basePackages = {"card", "product"})
@EnableJpaRepositories(basePackages = {"card", "product"})
public class PruebaTecnicaNovatecApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaNovatecApplication.class, args);
    }
}