package ua.artcode.daoSQL.interfaces;

/**
 * Created by work on 19.11.2016.
 */
public interface DeleteDAO {

    boolean deleteSubject(String subject_name) throws ClassNotFoundException;
    boolean deleteGroup(String group_name) throws ClassNotFoundException;
    boolean deleteTeacher(String teacher_name) throws ClassNotFoundException;
    boolean deleteStudent(String student_name) throws ClassNotFoundException;


}
