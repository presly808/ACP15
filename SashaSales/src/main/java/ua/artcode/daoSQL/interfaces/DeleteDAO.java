package ua.artcode.daoSQL.interfaces;

/**
 * Created by work on 19.11.2016.
 */
public interface DeleteDAO {

    boolean deleteSubject(String subject_name);
    boolean deleteGroup(String group_name);
    boolean deleteTeacher(String teacher_name);
    boolean deleteStudent(String student_name);


}
