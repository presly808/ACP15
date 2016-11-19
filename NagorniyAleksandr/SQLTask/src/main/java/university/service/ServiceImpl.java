package university.service;

import university.dao.QueryCreator;
import university.exceptions.*;
import university.models.Group;
import university.models.Student;
import university.models.Subject;
import university.models.Teacher;

import javax.management.InstanceNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements Service {

    private QueryCreator queryCreator;

    public ServiceImpl(QueryCreator queryCreator) {
        this.queryCreator = queryCreator;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws DBUnavailableException, InvalidQueryParameterException {
        validateOffsetAndLength(offset, length);

        try {
            return queryCreator.getStudentsList(offset, length);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    private void validateOffsetAndLength(int offset, int length) throws InvalidQueryParameterException {
        if (offset < 1) throw new InvalidQueryParameterException("Offset parameter is invalid");
        if (length < 1) throw new InvalidQueryParameterException("Length parameter is invalid");
    }

    @Override
    public List<Subject> getSubjectsList(int offset, int length) throws DBUnavailableException, InvalidQueryParameterException {
        validateOffsetAndLength(offset, length);

        try {
            return queryCreator.getSubjectsList(offset, length);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws InvalidQueryParameterException, DBUnavailableException {
        validateOffsetAndLength(offset, length);

        try {
            return queryCreator.getGroupList(offset, length);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length)
            throws DBUnavailableException, InvalidQueryParameterException {

        validateOffsetAndLength(offset, length);

        try {
            return queryCreator.getTeachersList(offset, length);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean addStudent(Student student)
            throws InvalidQueryParameterException, DBUnavailableException, GroupNotFoundException {

        if (student == null) throw
                new InvalidQueryParameterException("Student is null");

        if (student.getGroup() == null) throw
                new InvalidQueryParameterException("Students group is null");


        try {
            return queryCreator.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean addGroup(Group group) throws InvalidQueryParameterException,
            GroupAlreadyExistsException, DBUnavailableException {

        if (group == null) throw
                new InvalidQueryParameterException("Qroup is null");

        try {
            return queryCreator.addGroup(group);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean addSubject(Subject subject) throws InvalidQueryParameterException,
            SubjectAlreadyExistsException, SubjectCategoryNotFoundException, DBUnavailableException {
        if (subject == null) throw
                new InvalidQueryParameterException("Subject is null");

        if (subject.getCategory() == null) throw
                new InvalidQueryParameterException("Subject category is null");


        try {
            return queryCreator.addSubject(subject);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws InvalidQueryParameterException, DBUnavailableException {
        if (teacher == null) throw
                new InvalidQueryParameterException("Teacher is null");

        try {
            return queryCreator.addTeacher(teacher);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws DBUnavailableException,
            InvalidQueryParameterException, GroupNotFoundException, StudentNotFoundException {


        if (studentWithNewData == null) throw
                new InvalidQueryParameterException("Student is null");

        if (studentWithNewData.getGroup() == null) throw
                new InvalidQueryParameterException("Students group is null");

        try {
            return queryCreator.editStudent(studentWithNewData);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws InvalidQueryParameterException,
            GroupAlreadyExistsException,
            DBUnavailableException, GroupNotFoundException {

        if (groupWithNewData == null) throw
                new InvalidQueryParameterException("Group is null");

        try {
            return queryCreator.editGroup(groupWithNewData);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws
            InvalidQueryParameterException, DBUnavailableException, TeacherNotFoundException {

        if (teacherWithNewData == null) throw
                new InvalidQueryParameterException("Teacher is null");

        try {
            return queryCreator.editTeacher(teacherWithNewData);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws
            InvalidQueryParameterException, SubjectCategoryNotFoundException,
            SubjectNotFoundException, DBUnavailableException {

        if (subjectWithNewData == null) throw
                new InvalidQueryParameterException("Subject is null");

        if (subjectWithNewData.getCategory() == null) throw
                new InvalidQueryParameterException("Subject category is null");

        try {
            return queryCreator.editSubject(subjectWithNewData);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws GroupNotFoundException, SQLException, InvalidQueryParameterException {
        if (group == null) throw
                new InvalidQueryParameterException("Group is null");

        return queryCreator.getStudentOfGroup(group);
    }

    @Override
    public List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws InstanceNotFoundException {
        return null;
    }

    @Override
    public List<Subject> getSubjectsThatStudyAllGroups() throws InstanceNotFoundException {
        return null;
    }

    @Override
    public Teacher getTeacherWithMaxExperience() {
        return null;
    }

    @Override
    public Teacher getTeacherWithMinExperience() {
        return null;
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanYears(int years) {
        return null;
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanThreeYears() {
        return null;
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(String category) throws InstanceNotFoundException {
        return null;
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() {
        return null;
    }

    @Override
    public double averageRateOfSubject(Subject subject) throws InstanceNotFoundException {
        return 0;
    }

    @Override
    public double averageRateOfSubjectByGroup(Subject subject, Group group) {
        return 0;
    }

    @Override
    public void showGroupWithMoreThanThreeStudentsStudyPhilosophy() {

    }

    @Override
    public void showGroupWithMoreThanStudentsStudySubject(Subject subject, int countOfStudents) throws InstanceNotFoundException {

    }
}
