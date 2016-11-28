package university.models;


import javax.persistence.*;

@Entity
@Table(name = "study")
public class Study extends IdEntity {

    @ManyToOne()
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group groupList;

    @ManyToOne()
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subjectList;

    @ManyToOne()
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacherList;

    public Study() {
    }

    public Study(Group groupList, Subject subjectList, Teacher teacherList) {
        this.groupList = groupList;
        this.subjectList = subjectList;
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + getId() +
                ", groupList=" + groupList +
                ", subjectList=" + subjectList +
                ", teacherList=" + teacherList +
                '}';
    }
}
