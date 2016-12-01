package university.dao.crud;

import org.springframework.stereotype.Component;
import university.exceptions.*;
import university.models.*;
@Component
public interface CRUDQuery {

    boolean addStudent(Student student) throws AppDBException;

    boolean addGroup(Group group) throws AppDBException;

    boolean addSubject(Subject subject) throws AppDBException;

    boolean addSubjectCategory(SubjectCategory subjectCategory) throws AppDBException;

    boolean addTeacher(Teacher teacher) throws AppDBException;

    boolean editStudent(Student studentWithNewData) throws AppDBException;

    boolean editGroup(Group groupWithNewData) throws AppDBException;

    boolean editTeacher(Teacher teacherWithNewData) throws AppDBException;

    boolean editSubject(Subject subjectWithNewData) throws AppDBException;

    boolean editSubjectCategory(SubjectCategory subjectCategoryWithNewData) throws AppDBException;

    boolean deleteStudent(Student student) throws AppDBException;

    boolean deleteGroup(Group group) throws AppDBException;

    boolean deleteTeacher(Teacher teacher) throws AppDBException;

    boolean deleteSubject(Subject subject) throws AppDBException;

    boolean deleteSubjectCategory(SubjectCategory subjectCategory) throws AppDBException;

    Student getStudent(Student student) throws AppDBException;

    Group getGroup(Group group) throws AppDBException;

    Teacher getTeacher(Teacher teacher) throws AppDBException;

    Subject getSubject(Subject subject) throws AppDBException;

    SubjectCategory getSubjectCategory(SubjectCategory subjectCategory) throws AppDBException;
}
