package university.service;

import org.apache.log4j.Logger;
import university.dao.QueryCreator;
import university.exceptions.*;
import university.models.*;

import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements Service {

    private QueryCreator queryCreator;

    private static final Logger log = Logger.getLogger(ServiceImpl.class);

    public ServiceImpl(QueryCreator queryCreator) {
        this.queryCreator = queryCreator;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws DBUnavailableException, InvalidQueryParameterException {

        validateOffsetAndLength(offset, length);

        try {
            log.info("Request: get students list");
            return queryCreator.getStudentsList(offset, length);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    private void validateOffsetAndLength(int offset, int length) throws InvalidQueryParameterException {
        if (offset < 0) {
            log.error("Throw: Offset parameter is invalid");
            throw new InvalidQueryParameterException("Offset parameter is invalid");
        }
        if (length < 0) {
            log.error("Throw: Length parameter is invalid");
            throw new InvalidQueryParameterException("Length parameter is invalid");
        }
    }

    @Override
    public List<Subject> getSubjectsList(int offset, int length) throws DBUnavailableException, InvalidQueryParameterException {

        validateOffsetAndLength(offset, length);

        try {
            log.info("Request: get subjects list");
            return queryCreator.getSubjectsList(offset, length);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws InvalidQueryParameterException, DBUnavailableException {

        validateOffsetAndLength(offset, length);

        try {
            log.info("Request: get group list");
            return queryCreator.getGroupList(offset, length);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length)
            throws DBUnavailableException, InvalidQueryParameterException {

        validateOffsetAndLength(offset, length);

        try {
            log.info("Request: get teachers list");
            return queryCreator.getTeachersList(offset, length);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean addStudent(Student student)
            throws InvalidQueryParameterException, DBUnavailableException, GroupNotFoundException {

        validateStudentForNull(student);

        try {
            log.info("Request: add student");
            return queryCreator.addStudent(student);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    private void validateStudentForNull(Student student) throws InvalidQueryParameterException {
        if (student == null) {
            log.error("Throw: Student is null");
            throw new InvalidQueryParameterException("Student is null");
        }

        validateGroupForNull(student.getGroup());
    }

    @Override
    public boolean addGroup(Group group) throws InvalidQueryParameterException,
            GroupAlreadyExistsException, DBUnavailableException {

        validateGroupForNull(group);

        try {
            log.info("Request: add group");
            return queryCreator.addGroup(group);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    private void validateGroupForNull(Group group) throws InvalidQueryParameterException {
        if (group == null) {
            log.error("Throw: Group is null");
            throw new InvalidQueryParameterException("Group is null");
        }
    }

    @Override
    public boolean addSubject(Subject subject) throws InvalidQueryParameterException,
            SubjectAlreadyExistsException, SubjectCategoryNotFoundException, DBUnavailableException {

        validateSubjectForNull(subject);

        try {
            log.info("Request: add subject");
            return queryCreator.addSubject(subject);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    private void validateSubjectForNull(Subject subject) throws InvalidQueryParameterException {
        if (subject == null) {
            log.error("Throw: Subject is null");
            throw new InvalidQueryParameterException("Subject is null");
        }

        validateSubjectCategoryForNull(subject.getCategory());
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws InvalidQueryParameterException, DBUnavailableException {

        validateTeacherForNull(teacher);

        try {
            log.info("Request: add teacher");
            return queryCreator.addTeacher(teacher);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    private void validateTeacherForNull(Teacher teacher) throws InvalidQueryParameterException {
        if (teacher == null) {
            log.error("Throw: Teacher is null");
            throw new InvalidQueryParameterException("Teacher is null");
        }
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws DBUnavailableException,
            InvalidQueryParameterException, GroupNotFoundException, StudentNotFoundException {


        validateStudentForNull(studentWithNewData);

        try {
            log.info("Request: edit student");
            return queryCreator.editStudent(studentWithNewData);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws InvalidQueryParameterException,
            GroupAlreadyExistsException, DBUnavailableException, GroupNotFoundException {

        validateGroupForNull(groupWithNewData);

        try {
            log.info("Request: edit group");
            return queryCreator.editGroup(groupWithNewData);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws
            InvalidQueryParameterException, DBUnavailableException, TeacherNotFoundException {

        validateTeacherForNull(teacherWithNewData);

        try {
            log.info("Request: edit teacher");
            return queryCreator.editTeacher(teacherWithNewData);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws
            InvalidQueryParameterException, SubjectCategoryNotFoundException,
            SubjectNotFoundException, DBUnavailableException {

        validateSubjectForNull(subjectWithNewData);

        try {
            log.info("Request: edit subject");
            return queryCreator.editSubject(subjectWithNewData);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws GroupNotFoundException,
            SQLException, InvalidQueryParameterException {

        validateGroupForNull(group);

        log.info("Request: get student of group");
        return queryCreator.getStudentOfGroup(group);
    }

    @Override
    public List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws
            InvalidQueryParameterException, DBUnavailableException {

        validateOffsetAndLength(offset, length);
        validateSubjectForNull(subject);

        try {
            log.info("Request: get groups by subject");
            return queryCreator.getGroupsBySubject(subject, offset, length);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Subject> getSubjectsThatStudyAllGroups() throws DBUnavailableException {
        try {
            log.info("Request: get subject that study all groups");
            return queryCreator.getSubjectsThatStudyAllGroups();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public Teacher getTeacherWithMaxExperience() throws DBUnavailableException {
        try {
            log.info("Request: get teacher with max experience");
            return queryCreator.getTeacherWithMaxExperience();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public Teacher getTeacherWithMinExperience() throws DBUnavailableException {
        try {
            log.info("Request: get teacher with min experience");
            return queryCreator.getTeacherWithMinExperience();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws InvalidQueryParameterException, DBUnavailableException {
        if (years < 0) {
            log.error("Throw: Invalid input data");
            throw new InvalidQueryParameterException("Param \"years\" is incorrect");
        }

        try {
            log.info("Request: get teacher with experience more than" + years + " years");
            return queryCreator.getTeachersWithExperienceMoreThanYears(years);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws DBUnavailableException {
        try {
            log.info("Request: get teacher with experience more than three years");
            return queryCreator.getTeachersWithExperienceMoreThanThreeYears();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(SubjectCategory subjectCategory) throws
            InvalidQueryParameterException, DBUnavailableException {

        validateSubjectCategoryForNull(subjectCategory);

        try {
            log.info("Request: get of subjects by category" + subjectCategory.getTitle());
            return queryCreator.getListOfSubjectsByCategory(subjectCategory);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }

    }

    private void validateSubjectCategoryForNull(SubjectCategory subjectCategory) throws InvalidQueryParameterException {
        if (subjectCategory == null) {
            log.error("Throw: Subject category is null");
            throw new InvalidQueryParameterException("Subject category is null");
        }
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() throws DBUnavailableException {
        try {
            log.info("Request: get humanitarian subjects");
            return queryCreator.getListOfHumanitarianSubjects();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DBUnavailableException("DataBaseUnavailable");
        }
    }
}
