package ua.artcode.daoSQL.interfaces;

/**
 * Created by work on 19.11.2016.
 */
public interface InsertDAO {

    boolean addSubject(String subject_name, String subjects_description) throws ClassNotFoundException;
    boolean addGroup(String group_name) throws ClassNotFoundException;
    boolean addTeacher(String teacher_name, int experience, int subject_id) throws ClassNotFoundException;
    boolean addStudent(String student_name) throws ClassNotFoundException;


}
