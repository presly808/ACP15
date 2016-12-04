package ua.artcode.model;

import javax.persistence.*;

/**
 * Created by work on 27.11.2016.
 */

@MappedSuperclass
public class IdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public IdEntity() {
        super();
    }

    public IdEntity(int id) {
    super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdEntity idEntity = (IdEntity) o;

        return id == idEntity.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
