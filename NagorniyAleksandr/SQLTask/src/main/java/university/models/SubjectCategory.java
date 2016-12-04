package university.models;

import javax.persistence.*;

@Entity
@Table(name = "subject_categorys")
public class SubjectCategory extends IdEntity {

    @Column(name = "title", nullable = false, unique = true, length = 15)
    private String title;

    public SubjectCategory() {
    }

    public SubjectCategory(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SubjectCategory{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                '}';
    }
}