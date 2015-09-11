package com.realdolmen.ex.persistence;

import javax.ejb.Remote;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
@Remote
public interface RemoteGenericRepository<T> {

    T create(T t);
    T findById(Class<T> clazz, Long id);
    T update(T t);
    void delete(T t);
    void refresh(T t);
}
