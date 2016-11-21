package university.service;

import org.apache.log4j.Logger;
import university.dao.QueryCreator;
import university.exceptions.AppDBException;
import university.exceptions.InvalidQueryParameterException;
import university.models.*;

import java.util.List;

public class ServiceImpl implements Service {

    private QueryCreator queryCreator;

    private static final Logger log = Logger.getLogger(ServiceImpl.class);

    public ServiceImpl(QueryCreator queryCreator) {
        this.queryCreator = queryCreator;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws
            InvalidQueryParameterException, AppDBException {

        validateOffsetAndLength(offset, length);

        log.info("Request: get students list");
        return queryCreator.getStudentsList(offset, length);
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
    public List<Subject> getSubjectsList(int offset, int length) throws
            AppDBException, InvalidQueryParameterException {

        validateOffsetAndLength(offset, length);

        log.info("Request: get subjects list");
        return queryCreator.getSubjectsList(offset, length);
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws
            InvalidQueryParameterException, AppDBException {

        validateOffsetAndLength(offset, length);

        log.info("Request: get group list");
        return queryCreator.getGroupList(offset, length);
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length) throws
            AppDBException, InvalidQueryParameterException {

        validateOffsetAndLength(offset, length);

        log.info("Request: get teachers list");
        return queryCreator.getTeachersList(offset, length);
    }

    @Override
    public boolean addStudent(Student student)
            throws InvalidQueryParameterException, AppDBException {

        validateStudentForNull(student);


        log.info("Request: add student");
        return queryCreator.addStudent(student);
    }

    private void validateStudentForNull(Student student) throws InvalidQueryParameterException {
        if (student == null) {
            log.error("Throw: Student is null");
            throw new InvalidQueryParameterException("Student is null");
        }

        validateGroupForNull(student.getGroup());
    }

    @Override
    public boolean addGroup(Group group) throws InvalidQueryParameterException, AppDBException {

        validateGroupForNull(group);

        log.info("Request: add group");
        return queryCreator.addGroup(group);
    }

    private void validateGroupForNull(Group group) throws InvalidQueryParameterException {
        if (group == null) {
            log.error("Throw: Group is null");
            throw new InvalidQueryParameterException("Group is null");
        }
    }

    @Override
    public boolean addSubject(Subject subject) throws InvalidQueryParameterException, AppDBException {

        validateSubjectForNull(subject);

        log.info("Request: add subject");
        return queryCreator.addSubject(subject);
    }

    private void validateSubjectForNull(Subject subject) throws InvalidQueryParameterException {
        if (subject == null) {
            log.error("Throw: Subject is null");
            throw new InvalidQueryParameterException("Subject is null");
        }

        validateSubjectCategoryForNull(subject.getCategory());
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws InvalidQueryParameterException, AppDBException {

        validateTeacherForNull(teacher);

        log.info("Request: add teacher");
        return queryCreator.addTeacher(teacher);
    }

    private void validateTeacherForNull(Teacher teacher) throws InvalidQueryParameterException {
        if (teacher == null) {
            log.error("Throw: Teacher is null");
            throw new InvalidQueryParameterException("Teacher is null");
        }
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws
            InvalidQueryParameterException, AppDBException {

        validateStudentForNull(studentWithNewData);

        log.info("Request: edit student");
        return queryCreator.editStudent(studentWithNewData);
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws InvalidQueryParameterException, AppDBException {

        validateGroupForNull(groupWithNewData);

        log.info("Request: edit group");
        return queryCreator.editGroup(groupWithNewData);
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws
            InvalidQueryParameterException, AppDBException {

        validateTeacherForNull(teacherWithNewData);

        log.info("Request: edit teacher");
        return queryCreator.editTeacher(teacherWithNewData);
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws
            InvalidQueryParameterException, AppDBException {

        validateSubjectForNull(subjectWithNewData);

        log.info("Request: edit subject");
        return queryCreator.editSubject(subjectWithNewData);
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws
            InvalidQueryParameterException, AppDBException {

        validateGroupForNull(group);

        log.info("Request: get student of group");
        return queryCreator.getStudentOfGroup(group);
    }

    @Override
    public List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws
            InvalidQueryParameterException, AppDBException {

        validateOffsetAndLength(offset, length);
        validateSubjectForNull(subject);

        return queryCreator.getGroupsBySubject(subject, offset, length);
    }

    @Override
    public List<Subject> getSubjectsThatStudyAllGroups() throws AppDBException {

        log.info("Request: get subject that study all groups");
        return queryCreator.getSubjectsThatStudyAllGroups();
    }

    @Override
    public Teacher getTeacherWithMaxExperience() throws AppDBException {

        log.info("Request: get teacher with max experience");
        return queryCreator.getTeacherWithMaxExperience();
    }

    @Override
    public Teacher getTeacherWithMinExperience() throws AppDBException {

        log.info("Request: get teacher with min experience");
        return queryCreator.getTeacherWithMinExperience();
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws
            InvalidQueryParameterException, AppDBException {

        if (years < 0) {
            log.error("Throw: Invalid input data");
            throw new InvalidQueryParameterException("Param \"years\" is incorrect");
        }

        log.info("Request: get teacher with experience more than" + years + " years");
        return queryCreator.getTeachersWithExperienceMoreThanYears(years);
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws AppDBException {

        log.info("Request: get teacher with experience more than three years");
        return queryCreator.getTeachersWithExperienceMoreThanThreeYears();
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(SubjectCategory subjectCategory) throws
            InvalidQueryParameterException, AppDBException {

        validateSubjectCategoryForNull(subjectCategory);

        log.info("Request: get of subjects by category" + subjectCategory.getTitle());
        return queryCreator.getListOfSubjectsByCategory(subjectCategory);
    }

    private void validateSubjectCategoryForNull(SubjectCategory subjectCategory) throws
            InvalidQueryParameterException {

        if (subjectCategory == null) {
            log.error("Throw: Subject category is null");
            throw new InvalidQueryParameterException("Subject category is null");
        }
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() throws AppDBException {

        log.info("Request: get humanitarian subjects");
        return queryCreator.getListOfHumanitarianSubjects();
    }
}
