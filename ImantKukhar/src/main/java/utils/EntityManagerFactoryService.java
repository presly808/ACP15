package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Imant on 09.12.16.
 */
public class EntityManagerFactoryService {

    public static EntityManagerFactory instance;

    public static EntityManagerFactory getManagerFactory() {
        if (instance == null)
            instance = Persistence.createEntityManagerFactory("hibernate-unit");
        return instance;
    }


    public static EntityManagerFactoryService instance2;

    public static EntityManagerFactoryService getInstance() {
        if (instance2 == null)
            instance2 = new EntityManagerFactoryService();
        return instance2;
    }

    public EntityManagerFactory getManagerFactory2() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        return managerFactory;
    }

}
