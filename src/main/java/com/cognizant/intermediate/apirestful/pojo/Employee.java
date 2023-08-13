package com.cognizant.intermediate.apirestful.pojo;

import jakarta.persistence.*;


@Entity
@Table(name = "employee_records")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "email_id")
    private String email;

    public Employee(){}
    public Employee(String name, String email){
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[Id: "+this.id+" Name: "+this.name+" Email: "+this.email+"]";
    }
}
