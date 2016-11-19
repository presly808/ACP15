package university.dao.crud;

import university.exceptions.*;
import university.models.Group;
import university.models.Student;
import university.models.Subject;
import university.models.Teacher;

import java.sql.SQLException;

/**
 * Created by nagornyyalek on 17.11.2016.
 */
public interface CRUDQuery {

    boolean addStudent(Student student) throws
            SQLException, GroupNotFoundException;

    boolean addGroup(Group group) throws
            GroupAlreadyExistsException, SQLException;

    boolean addSubject(Subject subject) throws
            SubjectAlreadyExistsException, SubjectCategoryNotFoundException,
            SQLException;

    boolean addTeacher(Teacher teacher) throws
            SQLException;

    boolean editStudent(Student studentWithNewData) throws
            StudentNotFoundException, GroupNotFoundException, SQLException;

    boolean editGroup(Group groupWithNewData) throws
            GroupNotFoundException, SQLException;

    boolean editTeacher(Teacher teacherWithNewData) throws
            TeacherNotFoundException, SQLException;

    boolean editSubject(Subject subjectWithNewData) throws
            SubjectNotFoundException, SubjectCategoryNotFoundException, SQLException;

    boolean deleteStudent(Student student) throws
            StudentNotFoundException, SQLException;

    boolean deleteGroup(Group group) throws
            GroupNotFoundException, SQLException;

    boolean deleteTeacher(Teacher teacher) throws
            TeacherNotFoundException, SQLException;

    boolean deleteSubject(Subject subject) throws
            SubjectNotFoundException, SQLException;

    Student getStudent(Student student) throws
            StudentNotFoundException, SQLException;

    Group getGroup(Group group) throws
            GroupNotFoundException, SQLException;

    Teacher getTeacher(Teacher teacher) throws
            TeacherNotFoundException, SQLException;

    Subject getSubject(Subject subject) throws
            SubjectNotFoundException, SQLException;
}
