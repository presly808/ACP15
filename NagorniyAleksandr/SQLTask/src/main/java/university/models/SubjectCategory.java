package university.models;


public class SubjectCategory {

    private int id;
    private String title;

    public SubjectCategory() {
    }

    public SubjectCategory(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubjectCategory{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectCategory that = (SubjectCategory) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
