package com.example.todobackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class BackendApplication implements CommandLineRunner {

    private final MongoTemplate mongoTemplate; // Konstruktor-Injektion durch Lombok

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Prüfe MongoDB-Verbindung...");
        try {
            String dbName = mongoTemplate.getDb().getName();
            log.info("MongoDB verbunden! DB-Name: {}", dbName);
        } catch (Exception e) {
            log.error("Fehler bei der Verbindung zur MongoDB!", e);
        }
    }
}