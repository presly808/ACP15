package ua.artcode.dao;

import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Teacher;
import ua.artcode.util.UtilsMethod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by work on 28.11.2016.
 */
public class DaoStudentImplJPA implements DaoStudent<Student> {

    private EntityManagerFactory managerFactory;
    private DaoGroup daoGroup;

    public DaoStudentImplJPA(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;

    }

    @Override
    public Student create(Student student) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

                entityTransaction.begin();
                entityManager.persist(student);
                entityTransaction.commit();

        } catch (Exception e){
            entityTransaction.rollback();
            return null;
        } finally {
            entityManager.close();
        }

        return student;
    }

    @Override
    public boolean delete(String entity_name) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Student student = getEntityByName(entity_name, entityManager);

        try {
            entityTransaction.begin();
            entityManager.remove(student);
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
    public Student updateByGroup(String student_name, String group_name) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Student student = null;
        Group group = null;

        try {

            entityTransaction.begin();

            int idG = UtilsMethod.getIdOfGroup(group_name, managerFactory);
            int idS = UtilsMethod.getIdOfStudent(student_name, managerFactory);
            student = entityManager.find(Student.class, idS);
            group = entityManager.find(Group.class, idG);
            student.setGroup(group);
            entityTransaction.commit();

        } catch (Exception e){
            entityTransaction.rollback();
            return null;
        } finally {
            entityManager.close();
        }
        return student;
    }

    @Override
    public Student findById(Object id) {
        EntityManager entityManager = managerFactory.createEntityManager();

        try {
            return entityManager.find(Student.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Student> getAll() {
        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Student> query = entityManager.createQuery("SELECT t FROM Student t", Student.class);
        return query.getResultList();
    }

    @Override
    public Student getEntityByName(String student_name) {

        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :student_name", Student.class);
        query.setParameter("student_name", student_name);
        return query.getSingleResult();
    }

    public Student getEntityByName(String student_name, EntityManager entityManager) {

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :student_name", Student.class);
        query.setParameter("student_name", student_name);
        return query.getSingleResult();
    }


}
