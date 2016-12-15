package hibernateDB;

import converter.ResultSetToObjectConverter;
import converter.ResultSetToObjectListConverter;
import hibernateModel.Teacher;
import utils.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class TeacherDao {

    private static TeacherDao instance;

    public static final String GET_TEACHERS_LIST = "SELECT t FROM Teacher t";
    public static final String GET_TEACHER_WITH_MAX_EXPERIENCE = "SELECT t FROM Teacher t ORDER BY t.experience DESC";
    public static final String GET_TEACHER_WITH_MIN_EXPERIENCE = "SELECT t FROM Teacher t ORDER BY t.experience ASC";
    public static final String GET_TEACHERS_LIST_WITH_EXPERIENCE_MORE_THAN_YEARS = "SELECT t FROM Teacher t WHERE t.experience > :parameter ORDER BY t.experience ASC";


    public static TeacherDao getInstance() {
        if (instance == null)
            instance = new TeacherDao();
        return instance;
    }

    public boolean addNewTeacher(Teacher teacher) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(teacher);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public boolean deleteTeacher(Teacher teacher) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Teacher tempTeacher = manager.find(Teacher.class, teacher.getId());
        if (tempTeacher == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.remove(tempTeacher);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public Teacher getTeacher(Teacher teacher) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();

        Teacher gettingTeacher = manager.find(Teacher.class, teacher.getId());
        if (gettingTeacher != null) {
            manager.close();
        } else {
            manager.close();
        }
        return gettingTeacher;
    }

    public boolean editTeacher(Teacher updatedTeacher) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        if (manager.find(hibernateModel.Teacher.class, updatedTeacher.getId()) == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.merge(updatedTeacher);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public List<Teacher> getTeachersList(int limit, int offset) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Teacher> query = manager.createQuery(GET_TEACHERS_LIST, Teacher.class);
        query.setMaxResults(limit);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    public Teacher getTeacherWithMaxExperience() {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Teacher> query = manager.createQuery(GET_TEACHER_WITH_MAX_EXPERIENCE, Teacher.class);
        query.setMaxResults(1);

        return query.getSingleResult();
    }

    public Teacher getTeacherWithMinExperience() {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Teacher> query = manager.createQuery(GET_TEACHER_WITH_MIN_EXPERIENCE, Teacher.class);
        query.setMaxResults(1);

        return query.getSingleResult();
    }

    public Teacher getTeacherListWithExperienceMoreThanYears(int yearsValue) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Teacher> query = manager.createQuery(GET_TEACHERS_LIST_WITH_EXPERIENCE_MORE_THAN_YEARS, Teacher.class);
        query.setParameter("parameter", yearsValue);

        return query.getSingleResult();
    }
}
