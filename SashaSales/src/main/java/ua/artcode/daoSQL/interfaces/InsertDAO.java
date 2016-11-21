package ua.artcode.daoSQL.interfaces;

/**
 * Created by work on 19.11.2016.
 */
public interface InsertDAO {

    boolean addSubject(String subject_name, String subjects_description);
    boolean addGroup(String group_name);
    boolean addTeacher(String teacher_name, int experience, int subject_id);
    boolean addStudent(String student_name);
    boolean addFieldStudy(int id_group, int id_subject);

    boolean addFieldMark(int id_student, int id_subject, int mark);
}
