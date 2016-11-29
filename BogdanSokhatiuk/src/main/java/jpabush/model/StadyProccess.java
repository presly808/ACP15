package jpabush.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lost on 28.11.2016.
 */

@Entity
@Table(name = "stady_process")
public class StadyProccess {
    @Id
    private int id;
    @ManyToOne()
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subjects;
    @Column(name = "mark")
    private int mark;

    public StadyProccess() {
    }

    public StadyProccess(Student student, Subject subjects, int mark) {
        this.student = student;
        this.subjects = subjects;
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject subjects) {
        this.subjects = subjects;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
