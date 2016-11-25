package university.models;


import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;


    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private SubjectCategory category;

    @Column(name = "description")
    private String description;

    public Subject() {
    }

    public Subject(int id, String name, SubjectCategory category, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        final StringBuilder sb = new StringBuilder("Subject{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return id == subject.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
