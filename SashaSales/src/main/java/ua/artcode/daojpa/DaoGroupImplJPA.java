package ua.artcode.daojpa;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;

import javax.persistence.*;
import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public class DaoGroupImplJPA implements DaoGroup<Group> {

    private EntityManagerFactory managerFactory;

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
    public List<Group> getAllGroup() {

        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g", Group.class);
        return query.getResultList();
    }

}
