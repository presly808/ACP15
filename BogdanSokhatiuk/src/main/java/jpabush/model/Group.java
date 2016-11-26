package jpabush.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lost on 12.11.2016.
 */
@Entity
@Table(name = "groups")
public class Group extends IdEntity {
    @Column
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, int id) {
        this.name = name;
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
