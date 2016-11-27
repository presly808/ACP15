package dao;

import model.Student;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static factory.LazySingletonEntityManagerfactory.getEntityMangerFactory;

/**
 * Created by Jack on 18.11.2016.
 */
public interface CommonDAO<ENTITY_CLASS, ID_TYPE> {


    Logger LOGGER = Logger.getLogger(CommonDAO.class);
    EntityManagerFactory factory = getEntityMangerFactory();
    //EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate-unit");

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

    default ENTITY_CLASS findById(ID_TYPE id, Class<ENTITY_CLASS> entityClass) {

        EntityManager manager = factory.createEntityManager();
        //EntityTransaction transaction = manager.getTransaction();

        try {

            ENTITY_CLASS entity = manager.find(entityClass, id);
            LOGGER.info("Finded entity with id = " + id);
            return entity;

        } finally {
            manager.close();
        }
    }

    default List<ENTITY_CLASS> getAllByEntityClass(Class<ENTITY_CLASS> entityClass) {

        EntityManager manager = factory.createEntityManager();

        TypedQuery<ENTITY_CLASS> query = manager.createQuery("FROM " + entityClass.getName(), entityClass);//worked

        query.setMaxResults(22);
        query.setFirstResult(0);

        return query.getResultList();
    }

    default List<ENTITY_CLASS> getAllByEntityClassAndParameter(Class<ENTITY_CLASS> entityClass, Object parameter,
                                                               Object valueOfParameter) {

        EntityManager manager = factory.createEntityManager();

        TypedQuery<ENTITY_CLASS> query = manager.createQuery("FROM " + entityClass.getName() + " e " +
                "WHERE " + "e." + parameter + "=:" + parameter, entityClass);//worked

        query.setParameter(parameter.toString(), valueOfParameter);//ask what is first arg
        query.setMaxResults(22);
        query.setFirstResult(0);

        return query.getResultList();
    }

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
