package com.example.Alumni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlumniApplication {
    public static void main(String[] args) {
    	System.out.println("above main");
        SpringApplication.run(AlumniApplication.class, args);
        System.out.println("Server Started...");
    }
}
