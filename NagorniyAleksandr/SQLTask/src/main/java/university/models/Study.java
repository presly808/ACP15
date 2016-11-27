package university.models;


import javax.persistence.*;

@Entity
@Table(name = "study")
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
                "id=" + id +
                ", groupList=" + groupList +
                ", subjectList=" + subjectList +
                ", teacherList=" + teacherList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Study study = (Study) o;

        return id == study.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
