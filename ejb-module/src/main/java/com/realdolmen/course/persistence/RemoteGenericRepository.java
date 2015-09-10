package com.realdolmen.course.persistence;

/**
 * Created by YDEAX41 on 10/09/2015.
 */
public interface RemoteGenericRepository<T> {

    void create(T t);
    T findById(Class<T> clazz, Long id);
    void update(T t);
    void delete(T t);
    void refresh(T t);
}
