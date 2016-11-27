package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Jack on 12.11.2016.
 */
@Data
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;

    @ManyToMany(mappedBy = "lessonList",fetch = FetchType.LAZY)
    private List<Group> groupList;

    public Lesson() {
    }

    public Lesson(String name) {
        this.name = name;
    }
}
