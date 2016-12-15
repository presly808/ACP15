package hibernateModel;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Imant on 19.11.16.
 */

@Entity
@Table(name = "groups")
public class Group extends IdEntity{

    @Column(name = "group_name", length = 32, unique = true)
    private String name;

//    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
//    private List<Student> studentList;

    public Group() {
    }

    public Group(int id, String name) {
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
                ", name='" + name + '\'' +
                '}';
    }
}
