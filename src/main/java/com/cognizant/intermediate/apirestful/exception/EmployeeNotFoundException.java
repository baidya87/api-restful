package com.cognizant.intermediate.apirestful.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(long id){
        super(String.format("Employee with ID -> %d not found", id));
    }
}
