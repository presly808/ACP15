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

    public static final String UPDATE_STUDENT_BY_GROUP = "UPDATE student SET group_id = %d WHERE id = '%s';";

    public boolean updateStudentByGroup(int student_id, int group_id) throws ClassNotFoundException {

        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format(UPDATE_STUDENT_BY_GROUP, group_id, student_id));
            connection.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


}
