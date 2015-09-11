package com.realdolmen.ex.persistence;

import com.realdolmen.course.domain.Book;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface RemoteBookRepository {
    List<Book> findAll();
}
