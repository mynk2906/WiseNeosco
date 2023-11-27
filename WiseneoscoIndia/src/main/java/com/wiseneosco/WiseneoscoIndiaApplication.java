package com.wiseneosco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wiseneosco.Model.DatabaseConnectionChecker;

@SpringBootApplication
public class WiseneoscoIndiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiseneoscoIndiaApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner checkDatabaseConnection(DatabaseConnectionChecker connectionChecker) {
        return args -> {
            connectionChecker.checkDatabaseConnection();
        };
    }
}
