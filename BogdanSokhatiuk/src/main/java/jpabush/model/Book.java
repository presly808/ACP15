package jpabush.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lost on 21.11.2016.
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String name_author;
    @Column
    private int pages;
    @Column
    private double price;
    @Column(name = "publish_date")
    private Date publichDate;
    @Enumerated(EnumType.STRING)
    private BookType bookType;


    public Book() {
    }

    public Book(String name, String name_author, int pages, double price, Date publichDate, BookType bookType) {
        this.name = name;
        this.name_author = name_author;
        this.pages = pages;
        this.price = price;
        this.publichDate = publichDate;
        this.bookType = bookType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_author() {
        return name_author;
    }

    public void setName_author(String name_author) {
        this.name_author = name_author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name_author='" + name_author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public enum BookType {
        IT, Novel, Phichologic;
    }
}
