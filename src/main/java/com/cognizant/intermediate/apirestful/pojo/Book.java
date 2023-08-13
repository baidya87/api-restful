package com.cognizant.intermediate.apirestful.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "book_records")
public class Book {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "book_name")
    private String name;
    private String author;
    private float price;

    public  Book(){}
    public Book(String name, String author, float price){
        this.name = name;
        this.author = author;
        this.price = price;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
