package ua.artcode.daojpa;

import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public interface DaoSubject<T> {

    T create (T subject);
    boolean delete(T subject);
    T update(T subject);
    T findById(Object id);
    List<T> getAllSubject();

}
