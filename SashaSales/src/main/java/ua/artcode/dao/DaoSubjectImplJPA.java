package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoSubjectImplJPA implements DaoSubject<Subject> {

    @Autowired
    private EntityManagerFactory managerFactory;

    public DaoSubjectImplJPA() {
    }

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
    public boolean delete(String entity_name) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Subject subject = getEntityByName(entity_name, entityManager);

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
    public List<Subject> getAll() {
        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s", Subject.class);
        return query.getResultList();
    }

    @Override
    public Subject getEntityByName(String subject_name) {

        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :subject_name", Subject.class);
        query.setParameter("subject_name", subject_name);
        return query.getSingleResult();
    }

    public Subject getEntityByName(String subject_name, EntityManager entityManager) {

        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :subject_name", Subject.class);
        query.setParameter("subject_name", subject_name);
        return query.getSingleResult();
    }

}