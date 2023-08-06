package com.cognizant.intermediate.apirestful.service;

import com.cognizant.intermediate.apirestful.pojo.Employee;
import com.cognizant.intermediate.apirestful.pojo.Order;
import com.cognizant.intermediate.apirestful.pojo.Status;
import com.cognizant.intermediate.apirestful.repository.EmployeeRepository;
import com.cognizant.intermediate.apirestful.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);
    private final EmployeeRepository employeeRepository;
    private final OrderRepository orderRepository;

    public LoadDB(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        this.employeeRepository = employeeRepository;
        this.orderRepository = orderRepository;
        loadH2Database();
    }

    public void loadH2Database() {
        log.info("loading {} into h2 DB", employeeRepository.save(new Employee("Amit Baidya", "amit.baidya@gmail.com")));
        log.info("loading {} into h2 DB", employeeRepository.save(new Employee("Priyanka Paul", "priyanka.paul@gmail.com")));
    }

    @Bean
    public CommandLineRunner loadData(EmployeeRepository employeeRepository) {
        CommandLineRunner commandLineRunner = (args) -> {
            log.info("loading employee {} to H2 DB", employeeRepository.save(new Employee("Chandramouli Dutta", "chandra@yahoo.com")));
            log.info("loading employee {} to H2 DB", employeeRepository.save(new Employee("Vikram Datta", "vikram@yahoo.co.in")));
        };
        return commandLineRunner;
    }

    @Bean
    public CommandLineRunner loadOrder() {
        return (args) -> {
            log.info("Loading order {} to H2 DB", orderRepository.save(new Order("Apple Macbook Pro", Status.ONGOING)));
            log.info("Loading order {} to H2 DB", orderRepository.save(new Order("Windows DELL", Status.ONGOING)));
            log.info("Loading order {} to H2 DB", orderRepository.save(new Order("Chromebook", Status.CANCELLED)));
            log.info("Loading order {} to H2 DB", orderRepository.save(new Order("Apple iPAD Air", Status.COMPLETED)));
        };
    }

}
