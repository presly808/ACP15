package ua.artcode.daoSQL.implementations;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.UpdateDAO;
import ua.artcode.util.ConnectionFactory;
import ua.artcode.util.PropertiesHolder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by work on 13.11.2016.
 */
public class UpDateCommands implements UpdateDAO {

    private static final Logger LOGGER = Logger.getLogger(UpDateCommands.class);
    private static final String UPDATE_STUDENT_BY_GROUP = "UPDATE student SET group_id = %d WHERE id = '%s';";

    public UpDateCommands() {
    }

    public boolean updateStudentByGroup(int student_id, int group_id){

        LOGGER.info("update Student by id " + student_id + " to Group by id " + group_id);

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format(UPDATE_STUDENT_BY_GROUP, group_id, student_id));
            connection.commit();
            LOGGER.info("Student by id " + student_id + " to Group by id " + group_id + " was update");
            return true;

        } catch (SQLException e) {
            LOGGER.info("upDating Student by id " + student_id + " to Group by id " + group_id + " was iterupt", e);
            return false;
        }

    }


}
