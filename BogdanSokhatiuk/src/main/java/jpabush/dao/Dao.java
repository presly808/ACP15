package jpabush.dao;

import jpabush.model.Book;

/**
 * Created by lost on 26.11.2016.
 */
public interface Dao<T> {
    T create(T t);
    boolean delete (T t, int id);
    T update (T t);
    T findbyId(int id);

}
