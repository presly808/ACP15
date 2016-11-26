package jpabush.dao;

import jpabush.model.Book;

/**
 * Created by lost on 26.11.2016.
 */
public interface Dao<T> {
    T create(T t);
    boolean delete (T t);
    T update (T t);
    T findbyId(Object id);

}
