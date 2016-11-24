package jpabush.testRun;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by lost on 24.11.2016.
 */
public class Run {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory= Persistence.createEntityManagerFactory("hibernate-unit");
    }
}
