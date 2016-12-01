package jpabush.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lost on 21.11.2016.
 */
@Entity
@Table(name = "authors")
public class Author extends IdEntity {

    @Column(length = 20, nullable = false)
    private String name;
    @Column
    private double salary;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Transient
    private String sicret;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Adress adress;


    public Author() {
    }

    public Author(String name, double salary, Date birthday) {

        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
