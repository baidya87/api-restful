package com.cognizant.intermediate.apirestful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(long id){
        super(String.format("Employee with ID -> %d not found", id));
    }
}
