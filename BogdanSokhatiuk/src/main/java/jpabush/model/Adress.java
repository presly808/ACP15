package jpabush.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by lost on 21.11.2016.
 */
@Entity
@Table(name = "Adresses")
public class Adress extends IdEntity {
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String num;
    @OneToMany(mappedBy = "address")
    private List<Author> authors;

    public Adress(String city, String street, String num) {
        this.city = city;
        this.street = street;
        this.num = num;
    }

    public Adress() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
