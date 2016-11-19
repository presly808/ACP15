package ua.artcode.daoSQL.interfaces;

/**
 * Created by work on 19.11.2016.
 */
public interface UpdateDAO {

    boolean updateStudentByGroup(int student_id, int group_id) throws ClassNotFoundException;

}
