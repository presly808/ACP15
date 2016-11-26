package jpabush;

import jpabush.dao.BookDao;
import jpabush.dao.Dao;
import jpabush.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * Created by lost on 26.11.2016.
 */
public class TestDao {
    private BookDao dao;
    private EntityManagerFactory factory;


    @Before
    public void beforeMethod() {
        factory = Persistence.createEntityManagerFactory("hibernate-unit");
        dao = new BookDao(factory);
    }

    @Test
    public void testInsertAndDeleteBook() {
        Book book = new Book("Java book2", "Petrov", 205, 545.44, new Date(), Book.BookType.IT);
        dao.create(book);
        Assert.assertTrue(dao.delete(book));
    }

    @Test
    public void testGetListBookByType() {
        List<Book> list = dao.getbookByType(Book.BookType.IT);
        Assert.assertEquals(1,list.size());
    }
}
