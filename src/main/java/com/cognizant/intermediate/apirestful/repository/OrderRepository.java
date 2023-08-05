package com.cognizant.intermediate.apirestful.repository;

import com.cognizant.intermediate.apirestful.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
