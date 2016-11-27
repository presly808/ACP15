package model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Jack on 12.11.2016.
 */
@Data
@Entity
@Table(name = "prepods")
public class Prepod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int experience;
    @Column
    private int lesson_id;//(Один препод ведет один предмет)


    public Prepod() {
    }

}
