package university.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends IdEntity {

    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;


    //@OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    //private List<Student> studentList;

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

    @Override
    public String toString() {
        return "Group{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
