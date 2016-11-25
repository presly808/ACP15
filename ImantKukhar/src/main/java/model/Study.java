package model;

/**
 * Created by Imant on 19.11.16.
 */
public class Study {

    private Group group;
    private Subject subject;

    public Study() {
    }

    public Study(Group group, Subject subject) {
        this.group = group;
        this.subject = subject;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Study{" +
                "group=" + group +
                ", subject=" + subject +
                '}';
    }
}
