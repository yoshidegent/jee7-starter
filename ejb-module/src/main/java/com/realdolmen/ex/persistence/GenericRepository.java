package com.realdolmen.ex.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
@Stateless
@LocalBean
public class GenericRepository<T> implements RemoteGenericRepository<T>{

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public T create(T t)
    {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T findById(Class<T> tClass, Long id) {
        return entityManager.find(tClass, id);
    }

    @Override
    public T update(T t) {
        return this.entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        t = this.entityManager.merge(t);
        entityManager.remove(t);
    }

    @Override
    public void refresh(T t) {

    }
}
