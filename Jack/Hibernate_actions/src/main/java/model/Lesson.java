package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Jack on 12.11.2016.
 */
@Data
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String description;

    public Lesson() {
    }

}
