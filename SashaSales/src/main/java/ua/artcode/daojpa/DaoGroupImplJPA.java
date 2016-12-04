package ua.artcode.daojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;
import ua.artcode.model.modeljpa.Subject;
import ua.artcode.util.UtilsMethod;

import javax.persistence.*;
import java.util.List;

/**
 * Created by work on 27.11.2016.
 */

@Repository
public class DaoGroupImplJPA implements DaoGroup<Group> {

    @Autowired
    private EntityManagerFactory managerFactory;

    public DaoGroupImplJPA() {
    }

    public DaoGroupImplJPA(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Override
    public Group create(Group group) {

        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(group);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
            return null;
        } finally {
            entityManager.close();
        }

        return group;
    }

    @Override
    public boolean delete(Group group) {

        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        group = entityManager.find(Group.class, group.getId());

        try {
            entityTransaction.begin();
            entityManager.remove(group);
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
    public Group update(Group group) {
        return null;
    }

    @Override
    public Group findById(Object id) {

        EntityManager entityManager = managerFactory.createEntityManager();

        try {
            return entityManager.find(Group.class, id);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<Group> getAll() {

        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g", Group.class);
        return query.getResultList();
    }

    @Override
    public List<Group> getGroupsThatStudySubject(String subject_name) {


        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Subject> query1 = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :subject_name", Subject.class);
        query1.setParameter("subject_name", subject_name);
        Subject subject = query1.getSingleResult();


        TypedQuery<Group> query2 = entityManager.createQuery("SELECT g FROM Group g WHERE (?1) member g.subjectList ", Group.class);
        query2.setParameter(1, subject);
        List<Group> groupList = query2.getResultList();

        return  groupList;

    }
}
