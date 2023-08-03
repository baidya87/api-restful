package com.cognizant.intermediate.apirestful.service;

import com.cognizant.intermediate.apirestful.exception.EmployeeNotFoundException;
import com.cognizant.intermediate.apirestful.pojo.Employee;
import com.cognizant.intermediate.apirestful.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static  final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository ;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public Employee add(Employee employee){
        log.info("Employee : {}", employee);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll(){

        return employeeRepository.findAll();
    }

    public  Employee get(long id){
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
