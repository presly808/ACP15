package ua.artcode.dao;

import ua.artcode.model.Group;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.awt.*;
import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public class DaoTeacherImplJPA implements DaoTeacher<Teacher> {

    private EntityManagerFactory managerFactory;

    public DaoTeacherImplJPA(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Override
    public Teacher create(Teacher teacher) {

        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Subject subject = teacher.getSubject();

        try {

            if (subject.getId() == 0){
                entityTransaction.begin();
                entityManager.persist(subject);
                entityManager.persist(teacher);
                entityTransaction.commit();
            } else {
                entityTransaction.begin();
                entityManager.persist(teacher);
                entityTransaction.commit();
            }

        } catch (Exception e){
            entityTransaction.rollback();
            return null;
        } finally {
            entityManager.close();
        }

        return teacher;
    }

    @Override
    public boolean delete(String entity_name) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Teacher teacher = getEntityByName(entity_name, entityManager);

        try {
            entityTransaction.begin();
            entityManager.remove(teacher);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    public boolean delete1(int entity_name) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            Teacher teacher = entityManager.find(Teacher.class, 139);
            entityManager.remove(teacher);
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
    public Teacher update(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher findById(Object id) {
        EntityManager entityManager = managerFactory.createEntityManager();

        try {
            return entityManager.find(Teacher.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Teacher> getAll() {
        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return query.getResultList();
    }

    @Override
    public Teacher getEntityByName(String teacher_name) {

        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t WHERE t.name = :teacher_name", Teacher.class);
        query.setParameter("teacher_name", teacher_name);
        return query.getSingleResult();
    }

    public Teacher getEntityByName(String teacher_name, EntityManager entityManager) {

        TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t WHERE t.name = :teacher_name", Teacher.class);
        query.setParameter("teacher_name", teacher_name);
        return query.getSingleResult();
    }


}
