/*
package ua.artcode.model.modeljpa;

import javax.persistence.*;

@Entity ()
@Table(name = "study")
public class Study{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    Group group;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    Subject subject;

    public Study() {

    }

    public Study(Group group, Subject subject) {

        this.group = group;
        this.subject = subject;
    }

*/
/*    public Study(int id, Group group, Subject subject) {
        super(id);
        this.group = group;
        this.subject = subject;
    }*//*


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "group=" + group.toString() +
                ", subject=" + subject.toString() +
                '}';
    }
}
*/
