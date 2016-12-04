package ua.artcode.dao;

/**
 * Created by work on 27.11.2016.
 */
public interface DaoTeacher<T> extends Dao<T> {

    T update(T teacher);
    boolean delete1(int entity_name);
}
