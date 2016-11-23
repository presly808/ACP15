package university.models;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Study study = (Study) o;

        if (group != null ? !group.equals(study.group) : study.group != null) return false;
        if (subject != null ? !subject.equals(study.subject) : study.subject != null) return false;
        return teacher != null ? teacher.equals(study.teacher) : study.teacher == null;

    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }
}
