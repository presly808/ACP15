package factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Jack on 26.11.2016.
 */
public class LazySingletonEntityManagerfactory {

    private static EntityManagerFactory factory;

    private LazySingletonEntityManagerfactory() {
    }

    public static EntityManagerFactory getEntityMangerFactory() {

//        if (null == factory) {
//            factory = Persistence.createEntityManagerFactory("hibernate-unit");
//        }


        return null == factory ?
                factory = Persistence.createEntityManagerFactory("hibernate-unit") : factory;
    }

}
