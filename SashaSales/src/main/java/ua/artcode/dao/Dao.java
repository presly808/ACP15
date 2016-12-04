package ua.artcode.dao;

import ua.artcode.model.Group;

import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public interface Dao<T> {

    T create (T t);
    boolean delete(String t_name);
    T findById(Object id);
    List<T> getAll();
    T getEntityByName(String entity_name);

}
