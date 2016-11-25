package ua.artcode.daoSQL.interfaces;

import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import java.util.List;

/**
 * Created by work on 19.11.2016.
 */
public interface SelectDAO {

    List<Student> getStudents();
    List<Student> getStudentsByGroup(String nameGroup);
    List<Group> getGroups();
    List<Subject> getSubjects();
    List<Teacher> getTeachers();
    List<Teacher> getTeachersThatWorkMore3Years();
    List<Group> getGroupsThatStudySubject(String subject_name);
    double avgMarkBySubjectInUniversity(String subject_name);
    double avgMarkBySubjectInGroup(String group_name, String subject_name);


}
