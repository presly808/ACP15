package hibernateModel;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Imant on 19.11.16.
 */
@Entity
@Table(name = "study")
public class Study extends IdEntity {

    @ManyToOne()
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group groupList;

    @ManyToOne()
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subjectList;

    public Study() {
    }

    public Study(Group groupList, Subject subjectList) {
        this.groupList = groupList;
        this.subjectList = subjectList;
    }

    public Group getGroupList() {
        return groupList;
    }

    public void setGroupList(Group groupList) {
        this.groupList = groupList;
    }

    public Subject getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Subject subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "Study{" +
                "subjectList=" + subjectList +
                ", groupList=" + groupList +
                '}';
    }
}
