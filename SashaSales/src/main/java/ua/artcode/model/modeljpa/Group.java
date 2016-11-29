package ua.artcode.model.modeljpa;

import javax.persistence.*;
import java.util.List;

/**
 * Created by work on 12.11.2016.
 */

@Entity
@Table(name = "groups")
public class Group extends IdEntity {

    @Column(name = "group_name", nullable = false, length = 40, unique = true)
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                ", id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        return name != null ? name.equals(group.name) : group.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

}
