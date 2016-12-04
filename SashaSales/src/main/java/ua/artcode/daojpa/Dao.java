package ua.artcode.daojpa;

import ua.artcode.model.modelsql.Group;

import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public interface Dao<T> {

    T create (T t);
    boolean delete(T t);
    T findById(Object id);
    List<T> getAll();

}
