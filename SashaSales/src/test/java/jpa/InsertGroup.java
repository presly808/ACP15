package jpa;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by work on 27.11.2016.
 */
public class InsertGroup {

    public static void main(String[] args) {

        Group group = new Group("Base68");
        Subject subject = new Subject("Music", "Description Music");

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            //entityManager.persist(group);
            entityManager.persist(subject);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

}
