package ua.artcode.daojpa;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;

import java.util.List;

/**
 * Created by work on 28.11.2016.
 */
public interface DaoStudent<T> extends Dao<T> {

    T updateByGroup(String student_name, String group_name);

}
