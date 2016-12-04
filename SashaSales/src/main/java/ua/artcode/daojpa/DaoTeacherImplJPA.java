package ua.artcode.daojpa;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Subject;
import ua.artcode.model.modeljpa.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
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
    public boolean delete(Teacher teacher) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        teacher = entityManager.find(Teacher.class, teacher.getId());

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

}
