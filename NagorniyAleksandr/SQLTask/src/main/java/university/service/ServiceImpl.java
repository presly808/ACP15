package university.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import university.dao.QueryCreator;
import university.exceptions.AppDBException;
import university.exceptions.InvalidValueException;
import university.models.*;

import java.util.List;

import static university.util.Validator.*;

@Component
public class ServiceImpl implements Service {

    @Autowired
    private QueryCreator queryCreator;

    public ServiceImpl(QueryCreator queryCreator) {
        this.queryCreator = queryCreator;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws
            InvalidValueException, AppDBException {

        validateOffsetAndLength(offset, length);

        return queryCreator.getStudentsList(offset, length);
    }

    @Override
    public List<Subject> getSubjectsList(int offset, int length) throws
            AppDBException, InvalidValueException {

        validateOffsetAndLength(offset, length);

        return queryCreator.getSubjectsList(offset, length);
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws
            InvalidValueException, AppDBException {

        validateOffsetAndLength(offset, length);

        return queryCreator.getGroupList(offset, length);
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length) throws
            AppDBException, InvalidValueException {

        validateOffsetAndLength(offset, length);

        return queryCreator.getTeachersList(offset, length);
    }

    @Override
    public boolean addStudent(Student student)
            throws InvalidValueException, AppDBException {

        validateStudent(student);
;
        return queryCreator.addStudent(student);
    }


    @Override
    public boolean addGroup(Group group) throws InvalidValueException, AppDBException {

        validateGroup(group);

        return queryCreator.addGroup(group);
    }


    @Override
    public boolean addSubject(Subject subject) throws InvalidValueException, AppDBException {

        validateSubject(subject);

        return queryCreator.addSubject(subject);
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws InvalidValueException, AppDBException {

        validateTeacher(teacher);

        return queryCreator.addTeacher(teacher);
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws
            InvalidValueException, AppDBException {

        validateStudent(studentWithNewData);

        return queryCreator.editStudent(studentWithNewData);
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws InvalidValueException, AppDBException {

        validateGroup(groupWithNewData);

        return queryCreator.editGroup(groupWithNewData);
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws
            InvalidValueException, AppDBException {

        validateTeacher(teacherWithNewData);

        return queryCreator.editTeacher(teacherWithNewData);
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws
            InvalidValueException, AppDBException {

        validateSubject(subjectWithNewData);

        return queryCreator.editSubject(subjectWithNewData);
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws
            InvalidValueException, AppDBException {

        validateGroup(group);

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

        return queryCreator.getSubjectsThatStudyAllGroups();
    }

    @Override
    public Teacher getTeacherWithMaxExperience() throws AppDBException {

        return queryCreator.getTeacherWithMaxExperience();
    }

    @Override
    public Teacher getTeacherWithMinExperience() throws AppDBException {

        return queryCreator.getTeacherWithMinExperience();
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws
            InvalidValueException, AppDBException {

        if (years < 0) {
            throw new InvalidValueException("Param \"years\" is incorrect");
        }

        return queryCreator.getTeachersWithExperienceMoreThanYears(years);
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws AppDBException {

        return queryCreator.getTeachersWithExperienceMoreThanThreeYears();
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(SubjectCategory subjectCategory) throws
            InvalidValueException, AppDBException {

        validateSubjectCategory(subjectCategory);

        return queryCreator.getListOfSubjectsByCategory(subjectCategory);
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() throws AppDBException {

        return queryCreator.getListOfHumanitarianSubjects();
    }
}
