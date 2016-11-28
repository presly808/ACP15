package university.models;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends IdEntity{

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "experience")
    private int experience;

    public Teacher() {
    }

    public Teacher(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
