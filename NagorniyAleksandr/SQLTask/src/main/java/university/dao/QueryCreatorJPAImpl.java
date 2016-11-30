package university.dao;

import org.apache.log4j.Logger;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryJPAImpl;
import university.exceptions.AppDBException;
import university.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by nagornyyalek on 28.11.2016.
 */
public class QueryCreatorJPAImpl implements QueryCreator {


    private static final Logger LOGGER = Logger.getLogger(CRUDQueryJPAImpl.class);
    public static final String GET_STUDENTS_LIST = "FROM Student";
    public static final String GET_SUBJECTS_LIST = "FROM Subject";
    public static final String GET_GROUPS_LIST = "FROM Group";
    public static final String GET_TEACHERS_LIST = "FROM Teacher ";
    public static final String GET_STUDENTS_OF_GROUP = "SELECT s FROM Student s WHERE s.group =:parameter";
    public static final String GET_GROUPS_BY_SUBJECT = "SELECT st.groupList FROM Study st WHERE st.subjectList =:parameter";
    public static final String GET_SUBJECTS_THAT_STUDY_ALL_GROUPS = "SELECT st.subjectList FROM Study st GROUP BY st.subjectList HAVING count (st.groupList) = (SELECT count (gr) FROM Group gr)";
    public static final String GET_TEACHER_WITH_MAX_EXPERIENCE = "SELECT t FROM Teacher t ORDER BY experience DESC";
    public static final String GET_TEACHER_WITH_MIN_EXPERIENCE = "SELECT t FROM Teacher t ORDER BY experience ASC";
    public static final String GET_TEACHER_WITH_EXPERIENCE_MORE_THAN = "SELECT t FROM Teacher t WHERE experience > :parameter ORDER BY experience ASC";
    public static final String GET_LIST_OF_SUBJECTS_BY_CATEGORY = "SELECT s FROM Subject s WHERE s.category =:parameter";
    public static final String GET_LIST_OF_SUBJECTS_BY_CATEGORY_NAME = "SELECT s FROM Subject s WHERE s.category.title =:parameter";

    private EntityManagerFactory factory;
    private CRUDQuery crudQuery;

    public QueryCreatorJPAImpl(EntityManagerFactory factory, CRUDQuery crudQuery) {
        this.factory = factory;
        this.crudQuery = crudQuery;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Student> query = manager.createQuery(GET_STUDENTS_LIST, Student.class);
        query.setMaxResults(length);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    @Override
    public List<Subject> getSubjectsList(int offset, int length) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Subject> query = manager.createQuery(GET_SUBJECTS_LIST, Subject.class);
        query.setMaxResults(length);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Group> query = manager.createQuery(GET_GROUPS_LIST, Group.class);
        query.setMaxResults(length);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Teacher> query = manager.createQuery(GET_TEACHERS_LIST, Teacher.class);
        query.setMaxResults(length);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Student> query = manager.createQuery(
                GET_STUDENTS_OF_GROUP, Student.class);
        query.setParameter("parameter", group);

        return query.getResultList();
    }

    @Override
    public List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Group> query = manager.createQuery(
                GET_GROUPS_BY_SUBJECT, Group.class);
        query.setParameter("parameter", subject);
        query.setMaxResults(length);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    @Override
    public List<Subject> getSubjectsThatStudyAllGroups() throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Subject> query = manager.createQuery(
                GET_SUBJECTS_THAT_STUDY_ALL_GROUPS, Subject.class);

        return query.getResultList();
    }

    @Override
    public Teacher getTeacherWithMaxExperience() throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Teacher> query = manager.createQuery(GET_TEACHER_WITH_MAX_EXPERIENCE, Teacher.class);
        query.setMaxResults(1);

        return query.getSingleResult();
    }

    @Override
    public Teacher getTeacherWithMinExperience() throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Teacher> query = manager.createQuery(GET_TEACHER_WITH_MIN_EXPERIENCE, Teacher.class);
        query.setMaxResults(1);

        return query.getSingleResult();
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Teacher> query = manager.createQuery(GET_TEACHER_WITH_EXPERIENCE_MORE_THAN + " ", Teacher.class);
        query.setParameter("parameter", years);

        return query.getResultList();
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws AppDBException {
        return getTeachersWithExperienceMoreThanYears(3);
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(SubjectCategory category) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Subject> query = manager.createQuery(
                GET_LIST_OF_SUBJECTS_BY_CATEGORY, Subject.class);
        query.setParameter("parameter", category);

        return query.getResultList();
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(String categoryName) throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Subject> query = manager.createQuery(
                GET_LIST_OF_SUBJECTS_BY_CATEGORY_NAME, Subject.class);
        query.setParameter("parameter", categoryName);

        return query.getResultList();
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() throws AppDBException {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Subject> query = manager.createQuery(
                GET_LIST_OF_SUBJECTS_BY_CATEGORY_NAME, Subject.class);
        query.setParameter("parameter", "Humanities");

        return query.getResultList();
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
    public boolean addSubjectCategory(SubjectCategory subjectCategory) throws AppDBException {
        return crudQuery.addSubjectCategory(subjectCategory);
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
    public boolean editSubjectCategory(SubjectCategory subjectCategoryWithNewData) throws AppDBException {
        return crudQuery.editSubjectCategory(subjectCategoryWithNewData);
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
    public boolean deleteSubjectCategory(SubjectCategory subjectCategory) throws AppDBException {
        return crudQuery.deleteSubjectCategory(subjectCategory);
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

    @Override
    public SubjectCategory getSubjectCategory(SubjectCategory subjectCategory) throws AppDBException {
        return crudQuery.getSubjectCategory(subjectCategory);
    }
}