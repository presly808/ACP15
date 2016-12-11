package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Imant on 09.12.16.
 */
public class EntityManagerFactoryService {

    public static EntityManagerFactoryService instance;

    public static EntityManagerFactoryService getInstance() {
        if (instance == null)
            instance = new EntityManagerFactoryService();
        return instance;
    }

    public EntityManagerFactory getManagerFactory() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        return managerFactory;
    }
}
