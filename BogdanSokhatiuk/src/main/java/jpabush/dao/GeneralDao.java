package jpabush.dao;

import jdbcmySql.utils.PropertiesHolder;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by lost on 26.11.2016.
 */
public class GeneralDao<T> implements Dao<T> {
    protected static EntityManager manager;
    private Class<T> tClass;
    protected static final Logger LOG = Logger.getLogger(PropertiesHolder.class);

    public GeneralDao(EntityManager manager, Class<T> tClass) {
        this.manager = manager;
        this.tClass = tClass;
    }

    public static EntityManager getManager() {
        return manager;
    }

    public static void setManager(EntityManager manager) {
        GeneralDao.manager = manager;
    }

    @Override
    public T create(T t) {
        EntityTransaction transaction = manager.getTransaction();
        LOG.debug("Create transaction");
        try {
            transaction.begin();
            manager.persist(t);
            transaction.commit();
        } catch (Exception e) {
            LOG.error(e);
            transaction.rollback();
        }
        return t;
    }


    @Override
    public boolean delete(T t, int id) {
        EntityTransaction transaction = manager.getTransaction();
        t = manager.find(tClass, id);
        LOG.debug("Create transaction");
        try {
            transaction.begin();
            manager.remove(t);
            transaction.commit();
        } catch (Exception e) {
            LOG.error(e);
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public T update(T t) {
        EntityTransaction transaction = manager.getTransaction();
        LOG.debug("Create transaction");
        try {
            transaction.begin();
            manager.merge(t);
            transaction.commit();
        } catch (Exception e) {
            LOG.error(e);
            transaction.rollback();
        }
        return t;
    }

    @Override
    public T findbyId(int id) {
        EntityTransaction transaction = manager.getTransaction();

        try {
            T t = manager.find(tClass, id);
            return t;
        } catch (Exception e) {
            LOG.error(e);
            transaction.rollback();
        }
        return null;
    }

    public static void close() {
        manager.close();
        LOG.debug("Close connection");
    }
}
