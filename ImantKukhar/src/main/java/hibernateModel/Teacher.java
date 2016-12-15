package hibernateModel;

import javax.persistence.*;

/**
 * Created by Imant on 19.11.16.
 */
@Entity
@Table(name = "teachers")
public class Teacher extends IdEntity {

    @Column(name = "teacher_name")
    private String name;

    @Column(name = "experience")
    private int experience;

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;


    public Teacher() {
    }

    public Teacher(int id, String name, int experience, Subject subject) {
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

    @Override
    public String toString() {
        return "Teacher{" +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", subject=" + subject +
                '}';
    }
}
