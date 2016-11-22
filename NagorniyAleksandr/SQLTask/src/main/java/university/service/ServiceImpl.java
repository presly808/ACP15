package university.service;

import org.apache.log4j.Logger;
import university.dao.QueryCreator;
import university.exceptions.AppDBException;
import university.exceptions.InvalidValueException;
import university.models.*;

import java.util.List;

import static university.util.Validator.*;

public class ServiceImpl implements Service {

    private QueryCreator queryCreator;

    private static final Logger log = Logger.getLogger(ServiceImpl.class);

    public ServiceImpl(QueryCreator queryCreator) {
        this.queryCreator = queryCreator;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws
            InvalidValueException, AppDBException {

        validateOffsetAndLength(offset, length);

        log.info("Request: get students list");
        return queryCreator.getStudentsList(offset, length);
    }

    @Override
    public List<Subject> getSubjectsList(int offset, int length) throws
            AppDBException, InvalidValueException {

        validateOffsetAndLength(offset, length);

        log.info("Request: get subjects list");
        return queryCreator.getSubjectsList(offset, length);
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws
            InvalidValueException, AppDBException {

        validateOffsetAndLength(offset, length);

        log.info("Request: get group list");
        return queryCreator.getGroupList(offset, length);
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length) throws
            AppDBException, InvalidValueException {

        validateOffsetAndLength(offset, length);

        log.info("Request: get teachers list");
        return queryCreator.getTeachersList(offset, length);
    }

    @Override
    public boolean addStudent(Student student)
            throws InvalidValueException, AppDBException {

        validateStudent(student);

        log.info("Request: add student");
        return queryCreator.addStudent(student);
    }


    @Override
    public boolean addGroup(Group group) throws InvalidValueException, AppDBException {

        validateGroup(group);

        log.info("Request: add group");
        return queryCreator.addGroup(group);
    }



    @Override
    public boolean addSubject(Subject subject) throws InvalidValueException, AppDBException {

        validateSubject(subject);

        log.info("Request: add subject");
        return queryCreator.addSubject(subject);
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws InvalidValueException, AppDBException {

        validateTeacher(teacher);

        log.info("Request: add teacher");
        return queryCreator.addTeacher(teacher);
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws
            InvalidValueException, AppDBException {

        validateStudent(studentWithNewData);

        log.info("Request: edit student");
        return queryCreator.editStudent(studentWithNewData);
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws InvalidValueException, AppDBException {

        validateGroup(groupWithNewData);

        log.info("Request: edit group");
        return queryCreator.editGroup(groupWithNewData);
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws
            InvalidValueException, AppDBException {

        validateTeacher(teacherWithNewData);

        log.info("Request: edit teacher");
        return queryCreator.editTeacher(teacherWithNewData);
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws
            InvalidValueException, AppDBException {

        validateSubject(subjectWithNewData);

        log.info("Request: edit subject");
        return queryCreator.editSubject(subjectWithNewData);
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws
            InvalidValueException, AppDBException {

        validateGroup(group);

        log.info("Request: get student of group");
        return queryCreator.getStudentOfGroup(group);
    }

    @Override
    public List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws
            InvalidValueException, AppDBException {

        validateOffsetAndLength(offset, length);
        validateSubject(subject);

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
            InvalidValueException, AppDBException {

        if (years < 0) {
            log.error("Throw: Invalid input data");
            throw new InvalidValueException("Param \"years\" is incorrect");
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
            InvalidValueException, AppDBException {

        validateSubjectCategory(subjectCategory);

        log.info("Request: get of subjects by category" + subjectCategory.getTitle());
        return queryCreator.getListOfSubjectsByCategory(subjectCategory);
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() throws AppDBException {

        log.info("Request: get humanitarian subjects");
        return queryCreator.getListOfHumanitarianSubjects();
    }
}
