package hibernateDB;

import hibernateModel.Study;
import utils.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by Imant on 30.11.16.
 */
public class StudyDao {

    private static StudyDao instance;


    public static StudyDao getInstance() {
        if (instance == null)
            instance = new StudyDao();
        return instance;
    }

    public boolean addNewStudy(Study study) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(study);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public boolean deleteStudy(Study study) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Study removedStudy = manager.find(Study.class, study.getId());
        if (removedStudy == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.remove(removedStudy);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public Study getStudy(Study study) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();

        Study foundedStudy = manager.find(Study.class, study.getId());
        if (foundedStudy != null) {
            manager.close();
        } else {
            manager.close();
        }
        return foundedStudy;
    }

    public boolean editStudy(Study updatedStudy) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        if (manager.find(Study.class, updatedStudy.getId()) == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.merge(updatedStudy);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }
}
