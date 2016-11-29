package ua.artcode.daojpa;

import java.util.List;

/**
 * Created by work on 28.11.2016.
 */
public interface DaoStudent<T> {

    T create (T student);
    boolean delete(T student);
    T update(T student);
    T findById(Object id);
    List<T> getAllStudents();

}
