package university.dao;

import org.apache.log4j.Logger;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryJPAImpl;
import university.exceptions.AppDBException;
import university.models.*;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by nagornyyalek on 28.11.2016.
 */
public class QueryCreatorJPAImpl implements QueryCreator {


    private static final Logger LOGGER = Logger.getLogger(CRUDQueryJPAImpl.class);

    private EntityManagerFactory factory;
    private CRUDQuery crudQuery;

    public QueryCreatorJPAImpl(EntityManagerFactory factory, CRUDQuery crudQuery) {
        this.factory = factory;
        this.crudQuery = crudQuery;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws AppDBException {
        return null;
    }

    @Override
    public List<Subject> getSubjectsList(int offset, int length) throws AppDBException {
        return null;
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws AppDBException {
        return null;
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length) throws AppDBException {
        return null;
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws AppDBException {
        return null;
    }

    @Override
    public List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws AppDBException {
        return null;
    }

    @Override
    public List<Subject> getSubjectsThatStudyAllGroups() throws AppDBException {
        return null;
    }

    @Override
    public Teacher getTeacherWithMaxExperience() throws AppDBException {
        return null;
    }

    @Override
    public Teacher getTeacherWithMinExperience() throws AppDBException {
        return null;
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws AppDBException {
        return null;
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws AppDBException {
        return null;
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(SubjectCategory category) throws AppDBException {
        return null;
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(String categoryName) throws AppDBException {
        return null;
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() throws AppDBException {
        return null;
    }




    @Override
    public boolean addStudent(Student student) throws AppDBException {

        return crudQuery.addStudent(student);
    }

    @Override
    public boolean addGroup(Group group) throws AppDBException {

        return crudQuery.addGroup(group);
    }

    @Override
    public boolean addSubject(Subject subject) throws AppDBException {

        return crudQuery.addSubject(subject);
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws AppDBException {

        return crudQuery.addTeacher(teacher);
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws AppDBException {

        return crudQuery.editStudent(studentWithNewData);
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws AppDBException {

        return crudQuery.editGroup(groupWithNewData);
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws AppDBException {

        return crudQuery.editTeacher(teacherWithNewData);
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws AppDBException {

        return crudQuery.editSubject(subjectWithNewData);
    }

    @Override
    public boolean deleteStudent(Student student) throws AppDBException {

        return crudQuery.deleteStudent(student);
    }

    @Override
    public boolean deleteGroup(Group group) throws AppDBException {

        return crudQuery.deleteGroup(group);
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) throws AppDBException {

        return crudQuery.deleteTeacher(teacher);
    }

    @Override
    public boolean deleteSubject(Subject subject) throws AppDBException {

        return crudQuery.deleteSubject(subject);
    }

    @Override
    public Student getStudent(Student student) throws AppDBException {

        return crudQuery.getStudent(student);
    }

    @Override
    public Group getGroup(Group group) throws AppDBException {

        return crudQuery.getGroup(group);
    }

    @Override
    public Teacher getTeacher(Teacher teacher) throws AppDBException {

        return crudQuery.getTeacher(teacher);
    }

    @Override
    public Subject getSubject(Subject subject) throws AppDBException {

        return crudQuery.getSubject(subject);
    }
}