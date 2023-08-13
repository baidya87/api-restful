package com.cognizant.intermediate.apirestful.service;

import com.cognizant.intermediate.apirestful.repository.MySqlDummyJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoadIntoBookTable {

    Logger LOG = LoggerFactory.getLogger(LoadIntoBookTable.class);
    private final MySqlDummyJdbcRepository mySqlDummyJdbcRepository;

    public LoadIntoBookTable(MySqlDummyJdbcRepository mySqlDummyJdbcRepository) {
        this.mySqlDummyJdbcRepository = mySqlDummyJdbcRepository;
    }

    @Bean
    public CommandLineRunner loadBooks(){
        return (args) ->{
              //mySqlDummyJdbcRepository.loadBooks();
              mySqlDummyJdbcRepository.fetchBooks();
        };
    }
}
