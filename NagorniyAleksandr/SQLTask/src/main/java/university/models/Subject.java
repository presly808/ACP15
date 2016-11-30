package university.models;


import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject extends IdEntity {

    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private SubjectCategory category;

    @Column(name = "description")
    private String description;

    public Subject() {
    }

    public Subject(String name, SubjectCategory category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubjectCategory getCategory() {
        return category;
    }

    public void setCategory(SubjectCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
