package ua.artcode.daoSQL.implementations;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.DeleteDAO;
import ua.artcode.util.ConnectionFactory;
import ua.artcode.util.PropertiesHolder;

import java.sql.*;

/**
 * Created by work on 13.11.2016.
 */
public class DeleteCommands implements DeleteDAO {

    private static final Logger LOGGER = Logger.getLogger(DeleteCommands.class);

    private static final String DELETE_SUBJECT = "DELETE FROM subjects WHERE subject_name = ?;";
    private static final String DELETE_GROUP = "DELETE FROM groups WHERE group_name = ?;";
    private static final String DELETE_TEACHER = "DELETE FROM teachers WHERE teacher_name = ?;";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE student_name = ?;";

    public DeleteCommands() {
    }

    public boolean deleteSubject(String subject_name) {

        LOGGER.info("deleting Subject " + subject_name + " to DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SUBJECT);) {
            preparedStatement.setString(1, subject_name);
            preparedStatement.execute();
            LOGGER.info("Subject " + subject_name + "was delete to DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("deleting Subject " + subject_name + " to DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean deleteGroup(String group_name) {

        LOGGER.info("deleting Group " + group_name + " to DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GROUP);) {
            preparedStatement.setString(1, group_name);
            preparedStatement.execute();
            LOGGER.info("Group " + group_name + "was delete to DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("deleting Group " + group_name + " to DB SQL was itterupt", e);
            return false;
        }


    }

    public boolean deleteTeacher(String teacher_name) {

        LOGGER.info("deleting Teacher " + teacher_name + " to DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TEACHER);) {
            preparedStatement.setString(1, teacher_name);
            preparedStatement.execute();
            LOGGER.info("Teacher " + teacher_name + "was delete to DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("deleting Teacher " + teacher_name + " to DB SQL was itterupt", e);
            return false;
        }


    }

    public boolean deleteStudent(String student_name) {

        LOGGER.info("deleting Student " + student_name + " to DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);) {
            preparedStatement.setString(1, student_name);
            preparedStatement.execute();
            LOGGER.info("Student " + student_name + "was delete to DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("deleting Student " + student_name + " to DB SQL was itterupt", e);
            return false;
        }


    }

}
