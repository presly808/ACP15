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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column(name = "mark")
    private int mark;

    public StadyProccess() {
    }

    public StadyProccess(Student student, Subject subject, int mark) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
    }

    public StadyProccess(int id, Student student, Subject subject, int mark) {

        this.id = id;
        this.student = student;
        this.subject = subject;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}