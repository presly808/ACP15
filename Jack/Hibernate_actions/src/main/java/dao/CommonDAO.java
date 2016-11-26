package dao;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static dao.LazySingletonEntityManagerfactory.getEntityMangerFactory;

/**
 * Created by Jack on 18.11.2016.
 */
public interface CommonDAO<ENTITY_CLASS, ID_TYPE> {

//    default Class<ENTITY_CLASS> getClassmn(){
//
//
//        return
//    }


    Logger LOGGER = Logger.getLogger(StudentDAO.class);
    //EntityManagerFactory factory = getEntityMangerFactory();
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-unit");

    default ENTITY_CLASS create(ENTITY_CLASS entity) {

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(entity);
            transaction.commit();
            LOGGER.info("entity was saved");

        } catch (Exception e) {
            LOGGER.error("entity was not saved", e);
            transaction.rollback();
        } finally {
            manager.close();
        }
        return entity;
    }

    default ENTITY_CLASS findById(ID_TYPE id, Class<ENTITY_CLASS> cl) {

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {

            ENTITY_CLASS entity = manager.find(cl, id);
            LOGGER.info("Finded entity with id = " + id);
            return entity;

        } finally {
            manager.close();
        }
    }

    List<ENTITY_CLASS> getAll();

    List<ENTITY_CLASS> findAllByParam(Object param);

//    default boolean delete(ENTITY_CLASS entity){
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

    boolean removeById(ID_TYPE id);

    boolean addNewEntity(ENTITY_CLASS entity);

    boolean updateEntityInfo(ENTITY_CLASS entity);

}
