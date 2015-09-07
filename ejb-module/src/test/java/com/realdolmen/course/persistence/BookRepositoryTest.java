package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Book;
import org.junit.Before;
import org.junit.Test;

public class BookRepositoryTest extends DataSetPersistenceTest {
    private BookRepository repository;

    @Before
    public void initializeRepository() {
        repository = new BookRepository();
        repository.entityManager = entityManager();
    }

    @Test
    public void allBooksCanBeRetrieved() throws Exception {
        assertEquals(3, repository.findAll().size());
    }

    @Test
    public void bookCanBeRemovedById() throws Exception {
        repository.remove(1000);
        assertNull(entityManager().find(Book.class, 1000));
    }
}
