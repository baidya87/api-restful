package com.cognizant.intermediate.apirestful.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(long id){
        super(String.format("Order with <<ID: %d>> not found", id));
    }
}
