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

    public static final String DELETE_SUBJECT = "DELETE FROM subjects WHERE subject_name = '%s';";
    public static final String DELETE_GROUP = "DELETE FROM groups WHERE group_name = '%s';";
    public static final String DELETE_TEACHER = "DELETE FROM teachers WHERE teacher_name = '%s';";
    public static final String DELETE_STUDENT = "DELETE FROM student WHERE student_name = '%s';";


    public boolean deleteSubject(String subject_name) throws ClassNotFoundException {

        LOGGER.info("deleting Subject " + subject_name + " to DB SQL");

        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToDBUniversity();
            Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format(DELETE_SUBJECT, subject_name));
            connection.commit();
            LOGGER.info("Subject " + subject_name + "was delete to DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("deleting Subject " + subject_name + " to DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean deleteGroup(String group_name) throws ClassNotFoundException {

        LOGGER.info("deleting Group " + group_name + " to DB SQL");
        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format(DELETE_GROUP, group_name));
            connection.commit();
            LOGGER.info("Group " + group_name + "was delete to DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("deleting Group " + group_name + " to DB SQL was itterupt", e);
            return false;
        }


    }

    public boolean deleteTeacher(String teacher_name) throws ClassNotFoundException {

        LOGGER.info("deleting Teacher " + teacher_name + " to DB SQL");
        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format(DELETE_TEACHER, teacher_name));
            connection.commit();
            LOGGER.info("Teacher " + teacher_name + "was delete to DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("deleting Teacher " + teacher_name + " to DB SQL was itterupt", e);
            return false;
        }


    }

    public boolean deleteStudent(String student_name) throws ClassNotFoundException {

        LOGGER.info("deleting Student " + student_name + " to DB SQL");
        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            connection.setAutoCommit(false);
            statement.executeUpdate(String.format(DELETE_STUDENT, student_name));
            connection.commit();
            LOGGER.info("Student " + student_name + "was delete to DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("deleting Student " + student_name + " to DB SQL was itterupt", e);
            return false;
        }


    }

}
