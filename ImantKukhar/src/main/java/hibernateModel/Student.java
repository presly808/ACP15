package hibernateModel;

import javax.persistence.*;

/**
 * Created by Imant on 19.11.16.
 */
@Entity
@Table(name = "students")
public class Student extends IdEntity {

    @Column(name = "student_name", nullable = false, length = 40)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    public Student() {
    }

    public Student(int id, String name, Group group) {
        this.name = name;
        this.group = group;
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

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }
}

