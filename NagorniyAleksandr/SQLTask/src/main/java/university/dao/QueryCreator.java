package university.dao;

import university.dao.crud.CRUDQuery;
import university.exceptions.GroupNotFoundException;
import university.models.*;

import javax.management.InstanceNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface QueryCreator extends CRUDQuery {

    List<Student> getStudentsList(int offset, int length) throws SQLException;
    List<Subject> getSubjectsList(int offset, int length) throws SQLException;
    List<Group> getGroupList(int offset, int length) throws SQLException;
    List<Teacher> getTeachersList(int offset, int length) throws SQLException;

    List<Student> getStudentOfGroup(Group group) throws GroupNotFoundException, SQLException;

    List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws InstanceNotFoundException, SQLException;
    List<Subject> getSubjectsThatStudyAllGroups() throws InstanceNotFoundException, SQLException;

    Teacher getTeacherWithMaxExperience() throws SQLException;
    Teacher getTeacherWithMinExperience() throws SQLException;
    List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws SQLException;
    List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws SQLException;


    List<Subject> getListOfSubjectsByCategory(SubjectCategory category) throws InstanceNotFoundException, SQLException;
    List<Subject> getListOfSubjectsByCategory(String categoryName) throws InstanceNotFoundException, SQLException;
    List<Subject> getListOfHumanitarianSubjects() throws InstanceNotFoundException, SQLException;

    //double averageRateOfSubject(Subject subject) throws InstanceNotFoundException;
    //double averageRateOfSubjectByGroup(Subject subject, Group group);

    //void showGroupWithMoreThanThreeStudentsStudyPhilosophy();
    //void showGroupWithMoreThanStudentsStudySubject(Subject subject, int countOfStudents) throws InstanceNotFoundException;

}
