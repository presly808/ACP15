package hibernateModel;

import javax.persistence.*;

/**
 * Created by Imant on 19.11.16.
 */
@Entity
@Table(name = "subjects")
public class Subject extends IdEntity {

    @Column(name = "subject_name", nullable = false, unique = true, length = 20)
    private String name;

    @Column(name = "description")
    private String description;

    public Subject() {
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
