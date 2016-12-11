package ua.artcode.dao;

import ua.artcode.model.Group;

import java.util.List;

/**
 * Created by work on 03.12.2016.
 */
public interface DaoGroup<T> extends Dao<T> {

    T update(T t);
    List<T> getGroupsThatStudySubject(String subject_name);
    List<Group> getFirstLimitResuliList(int i, int size);
}
