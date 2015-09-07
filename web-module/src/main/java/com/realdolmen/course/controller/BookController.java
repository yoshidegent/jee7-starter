package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.persistence.BookRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BookController {
    @Inject
    BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public void remove(int bookId) {
        repository.remove(bookId);
    }
}
