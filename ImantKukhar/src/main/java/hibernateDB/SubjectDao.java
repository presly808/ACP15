package hibernateDB;

import hibernateModel.Subject;
import utils.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class SubjectDao {

    private static SubjectDao instance;

   public static final String GET_SUBJECTS_LIST = "SELECT s FROM Subject s";

    public static SubjectDao getInstance() {
        if (instance == null)
            instance = new SubjectDao();
        return instance;
    }

    public boolean addNewSubject(Subject subject) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(subject);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public boolean deleteSubject(Subject subject) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Subject tempSubject = manager.find(Subject.class, subject.getId());
        if (tempSubject == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.remove(tempSubject);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public Subject getSubject(Subject subject) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();

        Subject gettingSubject = manager.find(Subject.class, subject.getId());
        if (gettingSubject != null) {
            manager.close();
        } else {
            manager.close();
        }
        return gettingSubject;
    }

    public boolean editSubject(Subject updatedSubject) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        if (manager.find(Subject.class, updatedSubject.getId()) == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.merge(updatedSubject);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public List<Subject> getSubjectsList(int limit, int offset) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Subject> query = manager.createQuery(GET_SUBJECTS_LIST, Subject.class);
        query.setMaxResults(limit);
        query.setFirstResult(offset);

        return query.getResultList();
    }
}
