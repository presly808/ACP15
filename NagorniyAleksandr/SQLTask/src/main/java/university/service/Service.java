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

import org.springframework.stereotype.Component;
import university.exceptions.AppDBException;
import university.exceptions.InvalidValueException;
import university.models.*;

import java.util.List;

@Component
public interface Service {

    List<Student> getStudentsList(int offset, int length) throws AppDBException, InvalidValueException;
    List<Subject> getSubjectsList(int offset, int length) throws AppDBException, InvalidValueException;
    List<Group> getGroupList(int offset, int length) throws AppDBException, InvalidValueException;
    List<Teacher> getTeachersList(int offset, int length) throws AppDBException, InvalidValueException;

    boolean addStudent(Student student) throws InvalidValueException, AppDBException;
    boolean addGroup(Group group) throws InvalidValueException, AppDBException;
    boolean addSubject(Subject subject) throws InvalidValueException, AppDBException;
    boolean addTeacher(Teacher teacher) throws InvalidValueException, AppDBException;

    boolean editStudent(Student studentWithNewData) throws InvalidValueException, AppDBException;
    boolean editGroup(Group groupWithNewData) throws InvalidValueException, AppDBException;
    boolean editTeacher(Teacher teacherWithNewData) throws InvalidValueException, AppDBException;
    boolean editSubject(Subject subjectWithNewData) throws InvalidValueException, AppDBException;

    List<Student> getStudentOfGroup(Group group) throws AppDBException, InvalidValueException;

    List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws InvalidValueException, AppDBException;
    List<Subject> getSubjectsThatStudyAllGroups() throws AppDBException;

    Teacher getTeacherWithMaxExperience() throws AppDBException;
    Teacher getTeacherWithMinExperience() throws AppDBException;
    List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws InvalidValueException, AppDBException;
    List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws AppDBException;


    List<Subject> getListOfSubjectsByCategory(SubjectCategory subjectCategory) throws InvalidValueException, AppDBException;
    List<Subject> getListOfHumanitarianSubjects() throws AppDBException;

    //double averageRateOfSubject(Subject subject);
    //double averageRateOfSubjectByGroup(Subject subject, Group group);

    //void showGroupWithMoreThanThreeStudentsStudyPhilosophy();
    //void showGroupWithMoreThanStudentsStudySubject(Subject subject, int countOfStudents);

}
