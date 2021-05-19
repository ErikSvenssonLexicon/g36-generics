package org.example.data;

import java.util.Collection;

public interface BasicDAOCrud<T, ID> {
    T persist(T t);
    T findById(ID id);
    Collection<T> findAll();
    T update(T t);
    boolean delete(T t);
}
