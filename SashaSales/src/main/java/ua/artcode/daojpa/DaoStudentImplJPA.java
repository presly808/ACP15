package ua.artcode.daojpa;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;
import ua.artcode.model.modeljpa.Subject;
import ua.artcode.util.utilsql.UtilsMethod;

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
    public boolean delete(Student student) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        student = entityManager.find(Student.class, student.getId());

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
    public List<Student> getAllStudents() {
        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Student> query = entityManager.createQuery("SELECT t FROM Student t", Student.class);
        return query.getResultList();
    }

}
