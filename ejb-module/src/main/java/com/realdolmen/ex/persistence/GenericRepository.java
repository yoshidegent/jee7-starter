package com.realdolmen.ex.persistence;

import com.realdolmen.ex.persistence.interfaces.IGenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
public abstract class GenericRepository<T> implements IGenericRepository<T> {

    protected Class<T> persistentClass;

    public GenericRepository(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public T create(T t)
    {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(persistentClass, id);
    }

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        t = entityManager.merge(t);
        entityManager.remove(t);
    }

    @Override
    public void refresh(T t) {
    }

    @Override
    public List<T> findAll() {
        String queryString = "Select t from " + persistentClass.getSimpleName() + " t";
        TypedQuery<T> query = entityManager.createQuery(queryString, persistentClass);

        return query.getResultList();
    }

    public boolean checkEntityManagerIsNull()
    {
        return entityManager != null;
    }

    public void setEntityManager(EntityManager entityMAnager) {
        this.entityManager = entityMAnager;
    }
}
