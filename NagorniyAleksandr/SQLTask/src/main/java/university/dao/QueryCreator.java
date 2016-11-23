package university.dao;

import university.dao.crud.CRUDQuery;
import university.exceptions.AppDBException;
import university.models.*;

import java.util.List;

public interface QueryCreator extends CRUDQuery {

    List<Student> getStudentsList(int offset, int length) throws AppDBException;
    List<Subject> getSubjectsList(int offset, int length) throws AppDBException;
    List<Group> getGroupList(int offset, int length) throws AppDBException;
    List<Teacher> getTeachersList(int offset, int length) throws AppDBException;

    List<Student> getStudentOfGroup(Group group) throws AppDBException;

    List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws AppDBException;
    List<Subject> getSubjectsThatStudyAllGroups() throws AppDBException;

    Teacher getTeacherWithMaxExperience() throws AppDBException;
    Teacher getTeacherWithMinExperience() throws AppDBException;
    List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws AppDBException;
    List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws AppDBException;


    List<Subject> getListOfSubjectsByCategory(SubjectCategory category) throws AppDBException;
    List<Subject> getListOfSubjectsByCategory(String categoryName) throws AppDBException;
    List<Subject> getListOfHumanitarianSubjects() throws AppDBException;

    //double averageRateOfSubject(Subject subject);
    //double averageRateOfSubjectByGroup(Subject subject, Group group);

    //void showGroupWithMoreThanThreeStudentsStudyPhilosophy();
    //void showGroupWithMoreThanStudentsStudySubject(Subject subject, int countOfStudents);

}
