package jpabush.model;

import javax.persistence.*;

/**
 * Created by lost on 12.11.2016.
 */

@Entity
@Table(name = "teachers")
public class Teacher extends IdEntity {
    @Column
    private String name;
    @Column
    private int experience;
    @ManyToOne
    @JoinColumn(name="subject_id",referencedColumnName = "id")
    private Subject subject;

    public Teacher() {
    }

    public Teacher(String name, int experience, Subject subject) {
        this.name = name;
        this.experience = experience;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
