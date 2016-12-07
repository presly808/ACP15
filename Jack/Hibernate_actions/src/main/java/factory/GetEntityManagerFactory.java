package factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Jack on 26.11.2016.
 */
public final class GetEntityManagerFactory {

    private static EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("hibernate-unit");

    private GetEntityManagerFactory() {
    }

    public static EntityManagerFactory getEntityMangerFactory() {

        return factory;
    }


}
