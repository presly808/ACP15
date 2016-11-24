package jpabush.testRun;

import jpabush.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by lost on 25.11.2016.
 */
public class InsertBook {
    public static void main(String[] args) {
        Book book = new Book("Java book", "Ivanov", 143, 155.44, new Date(), Book.BookType.IT);
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {

            transaction.begin();
            manager.persist(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
    }
}
