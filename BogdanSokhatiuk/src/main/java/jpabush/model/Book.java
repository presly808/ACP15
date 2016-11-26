package jpabush.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lost on 21.11.2016.
 */
@Entity
@Table(name = "books")
public class Book extends IdEntity {
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
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return name_author != null ? name_author.equals(book.name_author) : book.name_author == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (name_author != null ? name_author.hashCode() : 0);
        return result;
    }

    public enum BookType {
        IT, Novel, Phichologic;
    }
}
