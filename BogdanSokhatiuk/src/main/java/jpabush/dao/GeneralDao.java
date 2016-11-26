package jpabush.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by lost on 26.11.2016.
 */
public class GeneralDao<T> implements Dao<T> {
    private static EntityManager manager;
    private Class<T> tClass;

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

        try {
            transaction.begin();
            manager.persist(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return t;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean delete(T t, Object id) {
        EntityTransaction transaction = manager.getTransaction();
        t = manager.find(tClass, id);

        try {

            transaction.begin();
            manager.remove(t);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T findbyId(Object id) {
        EntityTransaction transaction = manager.getTransaction();

        try {
            T t = manager.find(tClass, id);
            return t;
        } catch (Exception e) {
            transaction.rollback();
        }
        return null;
    }
    public static void close(){
        manager.close();
    }
}
