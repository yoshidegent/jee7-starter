package com.realdolmen.ex.persistence.interfaces;

import javax.ejb.Remote;
import java.util.Collection;
import java.util.List;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
public interface IGenericRepository<T> {

    T create(T t);
    T findById(Long id);
    T update(T t);
    void delete(T t);
    void refresh(T t);
    List<T> findAll();
}
