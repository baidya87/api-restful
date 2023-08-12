package com.cognizant.intermediate.apirestful.service;

import com.cognizant.intermediate.apirestful.exception.OrderNotFoundException;
import com.cognizant.intermediate.apirestful.pojo.Order;
import com.cognizant.intermediate.apirestful.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOne(long id){
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Order> allOrders(){
        return orderRepository.findAll();
    }

    public Order add(Order order) {
        return orderRepository.save(order);
    }
}
