package com.cognizant.intermediate.apirestful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(long id){
        super(String.format("Order with <<ID: %d>> not found", id));
    }
}
