package com.cognizant.intermediate.apirestful.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String orderName;
    private Status status;

    public Order(){}
    public Order(String orderName, Status status){
        this.orderName = orderName;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", status=" + status +
                '}';
    }
}
