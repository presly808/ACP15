package ua.artcode.daoSQL.interfaces;

/**
 * Created by work on 19.11.2016.
 */
public interface InsertDAO {

    boolean addSubject(String subject_name, String subjects_description);
    boolean addGroup(String group_name);
    boolean addTeacher(String teacher_name, int experience, int subject_id);
    boolean addStudent(String student_name);


}
