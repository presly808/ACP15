package jpabush.model;

import javax.persistence.*;

/**
 * Created by lost on 12.11.2016.
 */
@Entity
@Table(name = "students")
public class Student extends IdEntity {
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name="group_id",referencedColumnName = "id")
    private Group group;

    public Student() {
    }

    public Student(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}



