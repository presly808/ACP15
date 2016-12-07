package model;


import lombok.Data;

import javax.persistence.*;

/**
 * Created by Jack on 12.11.2016.
 */
@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int group_id;

    public Student() {
    }

    public Student(String name, int group_id) {
        this.name = name;
        this.group_id = group_id;
    }
}
