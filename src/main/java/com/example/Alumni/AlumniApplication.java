package com.example.Alumni;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
public class AlumniApplication {

    public static void main(String[] args) {
        System.out.println("above main");

        // ✅ Load .env.properties manually before Spring starts
        Dotenv dotenv = Dotenv.configure()
                .directory("src/main/resources")
                .filename(".env.properties")
                .load();

        // ✅ Print check
        System.out.println("Loaded DB_URL: " + dotenv.get("DB_URL"));
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));

        SpringApplication.run(AlumniApplication.class, args);
        System.out.println("Server Started...");
    }

    // ✅ Needed for placeholder resolution
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
