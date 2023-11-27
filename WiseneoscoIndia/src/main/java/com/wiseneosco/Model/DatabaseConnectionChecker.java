package com.wiseneosco.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

// check the connection 
@Component
public class DatabaseConnectionChecker {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseConnectionChecker(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void checkDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("Connected to the database successfully!");
        } catch (Exception e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }
}

