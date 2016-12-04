package ua.artcode.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by work on 12.11.2016.
 */

@Entity
@Table(name = "subjects")
public class Subject extends IdEntity {

    @Column(name = "subject_name", length = 40, unique = true)
    private String name;
    @Column(name = "subject_description", length = 500, nullable = false)
    private String description;
    @OneToMany(mappedBy = "subject")
    private List<Teacher> teachers;

    @ManyToMany(targetEntity = Group.class)
    private List<Group> groupList;

    public Subject() {
        super();
    }

    public Subject(String name) {
        super();
        this.name = name;
    }

    public Subject(int id, String name) {
        super(id);
        this.name = name;
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<Teacher> getTeacher() {
        return teachers;
    }

    public void setTeacher(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "Subject{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        return description != null ? description.equals(subject.description) : subject.description == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
