package jpabush;

import jpabush.dao.Dao;
import jpabush.dao.GeneralDao;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by lost on 26.11.2016.
 */
public class DaoTexture {
    protected static EntityManagerFactory managerFactory;
    protected static EntityManager manager;


    @BeforeClass
    public static void setUp() throws Exception {
        managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        manager=managerFactory.createEntityManager();

    }



}
