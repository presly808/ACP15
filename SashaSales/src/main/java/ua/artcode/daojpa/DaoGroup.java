package ua.artcode.daojpa;

import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public interface DaoGroup<T> {

    T create (T group);
    boolean delete(T group);
    T update(T group);
    T findById(Object id);
    List<T> getAllGroup();

}
