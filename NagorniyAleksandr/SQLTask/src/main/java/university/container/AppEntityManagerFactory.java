package university.container;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntityManagerFactory {

    private static final String PERSISTENCE_UNIT_NAME = "jpa-task";
    private static volatile EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {

        if (factory == null) {

            synchronized (AppEntityManagerFactory.class) {
                if (factory == null) {
                    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                }
            }
        }
        return factory;
    }


}
