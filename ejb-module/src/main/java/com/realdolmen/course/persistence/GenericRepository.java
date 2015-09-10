package com.realdolmen.course.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
public class GenericRepository<T> implements RemoteGenericRepository<T>{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(T t) {
        entityManager.persist(t);
    }

    @Override
    public T findById(Class<T> tClass, Long id) {
        return entityManager.find(tClass, id);
    }

    @Override
    public void update(T t) {
        
    }

    @Override
    public void delete(T t) {
        entityManager.remove(t);
    }

    @Override
    public void refresh(T t) {

    }
}
