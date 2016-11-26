package jpabush.dao;

import jpabush.model.Book;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lost on 26.11.2016.
 */
public class BookDao implements Dao<Book> {
    private EntityManagerFactory factory;

    public BookDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Book create(Book book) {
        EntityManager manager = factory.createEntityManager();
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
        return book;
    }

    @Override
    public boolean delete(Book book) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        book=manager.find(Book.class,book.getId());

        try {

            transaction.begin();
            manager.remove(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }
        return true;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book findbyId(Object id) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            Book book = manager.find(Book.class, id);
            return book;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return null;
    }

    public List<Book> getbookByType(Book.BookType bookType){
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Book> query=manager.createQuery("SELECT b FROM Book b WHERE b.bookType =:typeName", Book.class);
        query.setParameter("typeName", bookType);
        return query.getResultList();
    }
}
