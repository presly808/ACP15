package ua.artcode.model.modelsql;

/**
 * Created by work on 12.11.2016.
 */
public class Teacher {

    private int id;
    private String name;
    private int experience;
    private Subject subject;

    public Teacher(int id, String name, int experience, Subject subject) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.subject = subject;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", subject=" + subject.getName() +
                '}';
    }

}
