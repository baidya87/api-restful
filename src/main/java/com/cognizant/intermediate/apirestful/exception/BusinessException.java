package com.cognizant.intermediate.apirestful.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BusinessException {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        return employeeNotFoundException.getMessage();
    }


    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleOrderNotFoundException(OrderNotFoundException orderNotFoundException){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), orderNotFoundException.getMessage(), orderNotFoundException.getLocalizedMessage());
        ResponseEntity<ErrorDetails> responseEntity = new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        return  responseEntity;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDetails> handleValidationException(ConstraintViolationException constraintViolationException){
        List<String> errorMessages = constraintViolationException.getConstraintViolations()
                                    .stream()
                                    .map(constraintViolation -> constraintViolation.getMessage())
                                    .collect(Collectors.toList());
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), errorMessages.toString(), null);
        ResponseEntity<ErrorDetails> responseEntity = new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        return  responseEntity;
    }

}
