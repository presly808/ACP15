package ua.artcode.daojpa;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Subject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by work on 27.11.2016.
 */

public class DaoSubjectImplJPA implements DaoSubject<Subject> {

    private EntityManagerFactory managerFactory;

    public DaoSubjectImplJPA(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Override
    public Subject create(Subject subject) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(subject);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
            return null;
        } finally {
            entityManager.close();
        }

        return subject;
    }

    @Override
    public boolean delete(Subject subject) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        subject = entityManager.find(Subject.class, subject.getId());

        try {
            entityTransaction.begin();
            entityManager.remove(subject);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public Subject update(Subject subject) {
        return null;
    }

    @Override
    public Subject findById(Object id) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            Subject subject = entityManager.find(Subject.class, id);
            return subject;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Subject> getAllSubject() {
        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s", Subject.class);
        return query.getResultList();
    }
}
