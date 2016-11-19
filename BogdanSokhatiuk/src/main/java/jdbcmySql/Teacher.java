package jdbcmySql;

/**
 * Created by lost on 12.11.2016.
 */
public class Teacher {
    private int id;
    private String name;
    private int experience;
    private int subject;

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

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public Teacher(int id, String name, int experience, int subject) {

        this.id = id;
        this.name = name;
        this.experience = experience;
        this.subject = subject;
    }
}
