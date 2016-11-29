package ua.artcode.daojpa;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;
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

    public DaoStudentImplJPA(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Override
    public Student create(Student student) {
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Group group = student.getGroup();
        boolean res = containsGroupByName(group.getName());

        try {

            if (!res){
                entityTransaction.begin();
                entityManager.persist(group);
                entityManager.persist(student);
                entityTransaction.commit();
            } else {
                entityTransaction.begin();
                entityManager.persist(student);
                entityTransaction.commit();
            }

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
    public Student update(Student student) {
        return null;
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

    public boolean containsGroupByName(String group_name) {

        EntityManager entityManager = managerFactory.createEntityManager();

        TypedQuery<Group> query = entityManager.createQuery(String.format("SELECT g FROM Group g WHERE g.name LIKE '%s'",group_name), Group.class);
        List<Group> groupList = query.getResultList();
        if (groupList.size() > 0){
            return true;
        }

        return false;
    }

}
