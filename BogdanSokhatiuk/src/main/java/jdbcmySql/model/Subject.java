package jdbcmySql.model;

import jdbcmySql.annotation.SqlDB;

/**
 * Created by lost on 12.11.2016.
 */
public class Subject {
    @SqlDB
    private int id;
    @SqlDB
    private String name;
    @SqlDB
    private String description;

    public Subject() {
    }

    public Subject(int id) {

        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject(int id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }
}
