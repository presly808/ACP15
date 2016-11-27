package dao;

import model.Student;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Jack on 26.11.2016.
 */
public class StudentDAO implements CommonDAO<Student, Integer>{

    private static final Logger LOGGER = Logger.getLogger(StudentDAO.class);
    private EntityManagerFactory factory;

    public StudentDAO(EntityManagerFactory factory) {
        //LOGGER.trace("create StudentDAO instance");
        this.factory = factory;
    }



//    public Student findById(Integer id) {
//        return null;
//    }

    public List<Student> getAll() {
        return null;
    }

    public List<Student> findAllByParam(Object param) {
        return null;
    }

    public boolean remove(Student entity) {
        return false;
    }

    public boolean removeById(Integer id) {
        return false;
    }

    public boolean addNewEntity(Student entity) {
        return false;
    }

    public boolean updateEntityInfo(Student entity) {
        return false;
    }

//    public Student create(Student student) {
//
//        LOGGER.info("create new student");
//        EntityManager manager = factory.createEntityManager();
//        EntityTransaction transaction = manager.getTransaction();
//
//        try {
//            transaction.begin();
//            manager.persist(student);
//            transaction.commit();
//            LOGGER.info("student was saved");
//
//        } catch (Exception e) {
//            LOGGER.error("student was not saved", e);
//            transaction.rollback();
//        } finally {
//            manager.close();
//        }
//        return student;
//    }

//    public Student findById(Object id) {
//
//        EntityManager manager = factory.createEntityManager();
//        EntityTransaction transaction = manager.getTransaction();
//
//        try {
//
//            Student student = manager.find(Student.class, id);
//            LOGGER.info("Finded student with id = " + id);
//            return student;
//
//        } finally {
//            manager.close();
//        }
//    }
//
//    public boolean delete(Student student) {
//
//        EntityManager manager = factory.createEntityManager();
//        EntityTransaction transaction = manager.getTransaction();
//
//        student = manager.find(Student.class, student.getId());
//
//        try {
//            transaction.begin();
//            manager.remove(student);
//            transaction.commit();
//
//        } catch (Exception e) {
//            transaction.rollback();
//            return false;
//        } finally {
//            manager.close();
//        }
//        return true;
//    }
//
//    public List<Student> getByGroupId(int id){
//
//        EntityManager manager = factory.createEntityManager();
//        // JPQL - Java PErsistence Query Language (OOP + SQL)
//        TypedQuery<Student> query = manager.createQuery("FROM Student s WHERE s.group_id =:group_id", Student.class);
//
//        query.setParameter("group_id", id);
//        query.setMaxResults(20);
//        query.setFirstResult(0);
//
//        return query.getResultList();
//    }

}
