package ua.artcode.daoSQL.interfaces;

/**
 * Created by work on 19.11.2016.
 */
public interface CreateDAO {

    boolean createDBSQL(String nameDB);
    boolean createTableGroups();
    boolean createTableSubject();
    boolean createTableTeachers();
    boolean createTableStudents();
    boolean createTableStudy();


}
