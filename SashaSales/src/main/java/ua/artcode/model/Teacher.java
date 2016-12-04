package ua.artcode.model;

import javax.persistence.*;

/**
 * Created by work on 12.11.2016.
 */

@Entity
@Table(name = "teachers")
public class Teacher extends IdEntity{

    @Column(name = "teacher_name", nullable = false, length = 40, unique = true)
    private String name;
    @Column(name = "experience", length = 5)
    private int experience;
    @ManyToOne /*(cascade = CascadeType.PERSIST)*/
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    public Teacher() {
        super();
    }

    public Teacher(String name, int experience, Subject subject) {
        super();
        this.name = name;
        this.experience = experience;
        this.subject = subject;
    }

    public Teacher(int id, String name, int experience, Subject subject) {
        super(id);
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
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", subject=" + subject.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Teacher teacher = (Teacher) o;

        if (experience != teacher.experience) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        return subject != null ? subject.equals(teacher.subject) : teacher.subject == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + experience;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }
}
