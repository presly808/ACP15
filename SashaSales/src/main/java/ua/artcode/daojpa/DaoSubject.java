package ua.artcode.daojpa;

import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public interface DaoSubject<T> extends Dao<T>{

    T update(T subject);
    T findById(Object id);

}
