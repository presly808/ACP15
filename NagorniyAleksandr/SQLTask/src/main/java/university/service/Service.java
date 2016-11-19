package university.service;

/*
2. Используя university необходимо:
	  -получить список всех студентовб группб предметов и преподов
	  -добавить сутдента, группу, предмет, препода
	  -обновить информацию о сущностях бд (например студент изменил группу или препода уволили)
	  -получить список студентов определенной группы
	  -узнать какие группы изучают математику
	  -узнать какие предметы узучают все группы (если хотя бы одна не изучает, то предмет не входит в выборку)
	  -какие преподаватель имеют наименьший и наибольший опыт?
	  -какие преподы преподают больше 3-х лет
	  -получить список гуманитарных предметов
	  -узнать средний бал студентов по физике (всех и определенной группы)
	  -показать группу, в которой более 3-х студентов изучают философию (и выгнать с универа)
 */

import university.exceptions.*;
import university.models.*;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface Service {

    List<Student> getStudentsList(int offset, int length) throws DBUnavailableException, InvalidQueryParameterException;
    List<Subject> getSubjectsList(int offset, int length) throws DBUnavailableException, InvalidQueryParameterException;
    List<Group> getGroupList(int offset, int length) throws InvalidQueryParameterException, DBUnavailableException;
    List<Teacher> getTeachersList(int offset, int length) throws DBUnavailableException, InvalidQueryParameterException;

    boolean addStudent(Student student) throws InstanceAlreadyExistsException, InvalidQueryParameterException, DBUnavailableException, GroupNotFoundException;
    boolean addGroup(Group group) throws InstanceAlreadyExistsException, InvalidQueryParameterException, GroupAlreadyExistsException, DBUnavailableException;
    boolean addSubject(Subject subject) throws InstanceAlreadyExistsException, InvalidQueryParameterException, SubjectAlreadyExistsException, SubjectCategoryNotFoundException, DBUnavailableException;
    boolean addTeacher(Teacher teacher) throws InstanceAlreadyExistsException, InvalidQueryParameterException, DBUnavailableException;

    boolean editStudent(Student studentWithNewData) throws InstanceNotFoundException, DBUnavailableException, InvalidQueryParameterException, GroupNotFoundException, StudentNotFoundException;
    boolean editGroup(Group groupWithNewData) throws InstanceNotFoundException, InvalidQueryParameterException, GroupAlreadyExistsException, DBUnavailableException, GroupNotFoundException;
    boolean editTeacher(Teacher teacherWithNewData) throws InstanceNotFoundException, InvalidQueryParameterException, DBUnavailableException, TeacherNotFoundException;
    boolean editSubject(Subject subjectWithNewData) throws InstanceNotFoundException, InvalidQueryParameterException, SubjectCategoryNotFoundException, SubjectNotFoundException, DBUnavailableException;

    List<Student> getStudentOfGroup(Group group) throws InstanceNotFoundException, GroupNotFoundException, SQLException, InvalidQueryParameterException;

    List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws InstanceNotFoundException;
    List<Subject> getSubjectsThatStudyAllGroups() throws InstanceNotFoundException;

    Teacher getTeacherWithMaxExperience();
    Teacher getTeacherWithMinExperience();
    List<Teacher> getTeachersWithExperienceMoreThanYears(int years);
    List<Teacher> getTeachersWithExperienceMoreThanThreeYears();


    List<Subject> getListOfSubjectsByCategory(String category) throws InstanceNotFoundException;
    List<Subject> getListOfHumanitarianSubjects();

    double averageRateOfSubject(Subject subject) throws InstanceNotFoundException;
    double averageRateOfSubjectByGroup(Subject subject, Group group);

    void showGroupWithMoreThanThreeStudentsStudyPhilosophy();
    void showGroupWithMoreThanStudentsStudySubject(Subject subject, int countOfStudents) throws InstanceNotFoundException;

}
