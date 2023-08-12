package com.cognizant.intermediate.apirestful.repository;

import com.cognizant.intermediate.apirestful.pojo.Book;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookRepository {

    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Book save(Book book){
        return entityManager.merge(book);
    }

    public Book find(long id){
        return entityManager.find(Book.class, id);
    }

    public void findAll(){
    }

}
