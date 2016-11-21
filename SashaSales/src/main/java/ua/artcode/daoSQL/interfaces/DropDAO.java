package ua.artcode.daoSQL.interfaces;

/**
 * Created by work on 19.11.2016.
 */
public interface DropDAO {

    boolean dropTableGroups();
    boolean dropTableSubjects();
    boolean dropTableStudents();
    boolean dropTableTeachers();
    boolean dropTableStudy();
    boolean dropTableMarks();

}
