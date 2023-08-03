package com.cognizant.intermediate.apirestful;

import com.cognizant.intermediate.apirestful.pojo.Employee;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        Employee employee = new Employee("Amit Baidya", "amit.baidya@gmail.com");
        System.out.println(Optional.ofNullable(employee)
                                   .map(Employee::getEmail)
                                   .map(String :: toUpperCase)
                                   .orElseThrow(()->new RuntimeException("Employee is empty")));
    }
}
