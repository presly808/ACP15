package ua.artcode.daojpa;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;

import java.util.List;

/**
 * Created by work on 28.11.2016.
 */
public interface DaoStudent<T> {

    T create (T student);
    boolean delete(T student);
    T updateByGroup(String student_name, String group_name);
    T findById(Object id);
    List<T> getAllStudents();

}
