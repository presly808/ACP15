package hibernateDB;

import hibernateModel.Group;
import hibernateModel.Student;
import utils.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class StudentDao {

    private static StudentDao instance;

    public static final String GET_STUDENTS_LIST = "SELECT s FROM Student s";
    public static final String GET_STUDENTS_LIST_BY_GROUP = "SELECT s FROM Student s WHERE s.group =:parameter";


    public static StudentDao getInstance() {
        if (instance == null)
            instance = new StudentDao();
        return instance;
    }

    public boolean addNewStudent(Student student) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public boolean deleteStudent(Student student) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Student removedStudent = manager.find(Student.class, student.getId());
        if (removedStudent == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.remove(removedStudent);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public Student getStudent(Student student) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();

        Student foundedStudent = manager.find(Student.class, student.getId());
        if (foundedStudent != null) {
            manager.close();
        } else {
            manager.close();
        }
        return foundedStudent;
    }

    public boolean editStudent(Student updatedStudent) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        if (manager.find(Student.class, updatedStudent.getId()) == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.merge(updatedStudent);
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public List<Student> getStudentsList(int limit, int offset) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Student> query = manager.createQuery(GET_STUDENTS_LIST, Student.class);
        query.setMaxResults(limit);
        query.setFirstResult(offset);

        return query.getResultList();
    }

    public List<Student> getStudentsListByGroup(Group group) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Student> query = manager.createQuery(GET_STUDENTS_LIST_BY_GROUP, Student.class);
        query.setParameter("parameter", group);

        return query.getResultList();
    }
}
