package jpabush.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lost on 21.11.2016.
 */
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @Column(length = 20, nullable = false)
    private  String name;
    @Column
    private  double salary;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Transient
    private String sicret;

    public Author() {
    }

    public Author(int id, String name, double salary, Date birthday) {

        this.id = id;
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
