package university.dao;

import university.dao.crud.CRUDQuery;
import university.models.*;

import java.sql.SQLException;
import java.util.List;

public interface QueryCreator extends CRUDQuery {

    List<Student> getStudentsList(int offset, int length) throws SQLException;
    List<Subject> getSubjectsList(int offset, int length) throws SQLException;
    List<Group> getGroupList(int offset, int length) throws SQLException;
    List<Teacher> getTeachersList(int offset, int length) throws SQLException;

    List<Student> getStudentOfGroup(Group group) throws SQLException;

    List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws SQLException;
    List<Subject> getSubjectsThatStudyAllGroups() throws SQLException;

    Teacher getTeacherWithMaxExperience() throws SQLException;
    Teacher getTeacherWithMinExperience() throws SQLException;
    List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws SQLException;
    List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws SQLException;


    List<Subject> getListOfSubjectsByCategory(SubjectCategory category) throws SQLException;
    List<Subject> getListOfSubjectsByCategory(String categoryName) throws SQLException;
    List<Subject> getListOfHumanitarianSubjects() throws SQLException;

    //double averageRateOfSubject(Subject subject);
    //double averageRateOfSubjectByGroup(Subject subject, Group group);

    //void showGroupWithMoreThanThreeStudentsStudyPhilosophy();
    //void showGroupWithMoreThanStudentsStudySubject(Subject subject, int countOfStudents);

}
