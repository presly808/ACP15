package ua.artcode.daojpa;

import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public interface DaoTeacher<T> extends Dao<T> {

    T update(T teacher);

}
