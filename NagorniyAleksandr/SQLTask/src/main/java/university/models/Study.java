package university.models;

/**
 * Created by aleksandrnagorniy on 12.11.16.
 */
public class Study {

    private Group group;
    private Subject subject;
    private Teacher teacher;

    public Study() {
    }

    public Study(Group group, Subject subject, Teacher teacher) {
        this.group = group;
        this.subject = subject;
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Study{" +
                "group=" + group +
                ", subject=" + subject +
                ", teacher=" + teacher +
                '}';
    }
}
