package ua.artcode.daojpa;

import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public interface DaoTeacher<T> {

    T create (T teacher);
    boolean delete(T teacher);
    T update(T teacher);
    T findById(Object id);
    List<T> getAllTeacher();

}
