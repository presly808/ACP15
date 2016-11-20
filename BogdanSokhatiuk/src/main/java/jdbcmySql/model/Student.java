package jdbcmySql.model;

import jdbcmySql.annotation.SqlDB;

/**
 * Created by lost on 12.11.2016.
 */
public class Student {
    @SqlDB
    private int id;
    @SqlDB
    private String name;
    @SqlDB
    private int group;


    private int gfdg;

    public Student() {
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Student(int id, String name, int group) {

        this.id = id;
        this.name = name;
        this.group = group;
    }
}



