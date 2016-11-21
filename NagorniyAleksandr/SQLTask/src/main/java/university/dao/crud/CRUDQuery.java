package university.dao.crud;

import university.exceptions.*;
import university.models.Group;
import university.models.Student;
import university.models.Subject;
import university.models.Teacher;

/**
 * Created by nagornyyalek on 17.11.2016.
 */
public interface CRUDQuery {

    boolean addStudent(Student student) throws AppDBException;

    boolean addGroup(Group group) throws AppDBException;

    boolean addSubject(Subject subject) throws AppDBException;

    boolean addTeacher(Teacher teacher) throws AppDBException;

    boolean editStudent(Student studentWithNewData) throws AppDBException;

    boolean editGroup(Group groupWithNewData) throws AppDBException;

    boolean editTeacher(Teacher teacherWithNewData) throws AppDBException;

    boolean editSubject(Subject subjectWithNewData) throws AppDBException;

    boolean deleteStudent(Student student) throws AppDBException;

    boolean deleteGroup(Group group) throws AppDBException;

    boolean deleteTeacher(Teacher teacher) throws AppDBException;

    boolean deleteSubject(Subject subject) throws AppDBException;

    Student getStudent(Student student) throws AppDBException;

    Group getGroup(Group group) throws AppDBException;

    Teacher getTeacher(Teacher teacher) throws AppDBException;

    Subject getSubject(Subject subject) throws AppDBException;
}
