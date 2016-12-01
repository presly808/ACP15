package jpabush.model;

import javax.persistence.*;

/**
 * Created by lost on 12.11.2016.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;


    @Transient
    private double avrMark;

    public Student() {
    }

    public Student(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public Student(int id, String name, Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}



