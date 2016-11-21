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

import university.exceptions.AppDBException;
import university.exceptions.InvalidQueryParameterException;
import university.models.*;

import java.util.List;

public interface Service {

    List<Student> getStudentsList(int offset, int length) throws AppDBException, InvalidQueryParameterException;
    List<Subject> getSubjectsList(int offset, int length) throws AppDBException, InvalidQueryParameterException;
    List<Group> getGroupList(int offset, int length) throws AppDBException, InvalidQueryParameterException;
    List<Teacher> getTeachersList(int offset, int length) throws AppDBException, InvalidQueryParameterException;

    boolean addStudent(Student student) throws InvalidQueryParameterException, AppDBException;
    boolean addGroup(Group group) throws InvalidQueryParameterException, AppDBException;
    boolean addSubject(Subject subject) throws InvalidQueryParameterException, AppDBException;
    boolean addTeacher(Teacher teacher) throws InvalidQueryParameterException, AppDBException;

    boolean editStudent(Student studentWithNewData) throws InvalidQueryParameterException, AppDBException;
    boolean editGroup(Group groupWithNewData) throws InvalidQueryParameterException, AppDBException;
    boolean editTeacher(Teacher teacherWithNewData) throws InvalidQueryParameterException, AppDBException;
    boolean editSubject(Subject subjectWithNewData) throws InvalidQueryParameterException, AppDBException;

    List<Student> getStudentOfGroup(Group group) throws AppDBException, InvalidQueryParameterException;

    List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws InvalidQueryParameterException, AppDBException;
    List<Subject> getSubjectsThatStudyAllGroups() throws AppDBException;

    Teacher getTeacherWithMaxExperience() throws AppDBException;
    Teacher getTeacherWithMinExperience() throws AppDBException;
    List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws InvalidQueryParameterException, AppDBException;
    List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws AppDBException;


    List<Subject> getListOfSubjectsByCategory(SubjectCategory subjectCategory) throws InvalidQueryParameterException, AppDBException;
    List<Subject> getListOfHumanitarianSubjects() throws AppDBException;

    //double averageRateOfSubject(Subject subject);
    //double averageRateOfSubjectByGroup(Subject subject, Group group);

    //void showGroupWithMoreThanThreeStudentsStudyPhilosophy();
    //void showGroupWithMoreThanStudentsStudySubject(Subject subject, int countOfStudents);

}
