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

    List<Student> getStudents() throws ClassNotFoundException;
    List<Student> getStudentsByGroup(String nameGroup) throws ClassNotFoundException;
    List<Group> getGroups() throws ClassNotFoundException;
    List<Subject> getSubjects() throws ClassNotFoundException;
    List<Teacher> getTeachers() throws ClassNotFoundException;


}
