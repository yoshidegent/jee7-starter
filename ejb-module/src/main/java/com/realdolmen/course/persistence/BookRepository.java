package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Book> findAll() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public void remove(int id) {
        entityManager.remove(entityManager.getReference(Book.class, id));
    }
}
