package university.container;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppEntityManagerFactory {

    private static volatile EntityManagerFactory factory;

    public static EntityManagerFactory getInstance() {

        if (factory == null) {

            synchronized (AppEntityManagerFactory.class) {
                if (factory == null) {
                    factory = Persistence.createEntityManagerFactory("jpa-task");
                }
            }
        }
        return factory;
    }
}
