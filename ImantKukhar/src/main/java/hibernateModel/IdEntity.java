package hibernateModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Imant on 15.12.16.
 */

@MappedSuperclass
public abstract class IdEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        IdEntity idEntity = (IdEntity) object;
        return id == idEntity.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
