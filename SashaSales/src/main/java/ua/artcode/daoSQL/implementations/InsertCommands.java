package ua.artcode.daoSQL.implementations;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.InsertDAO;
import ua.artcode.util.ConnectionFactory;
import ua.artcode.util.PropertiesHolder;

import java.sql.*;

/**
 * Created by work on 13.11.2016.
 */
public class InsertCommands implements InsertDAO {

    private static final Logger LOGGER = Logger.getLogger(InsertCommands.class);

    public static final String INSERT_SUBJECT = "INSERT INTO subjects(subject_name, description) VALUES (?, ?);";
    public static final String INSERT_GROUP = "INSERT INTO groups(group_name) VALUES (?);";
    public static final String INSERT_TEACHER = "INSERT INTO teachers(teacher_name, experience, subject_id) VALUES (?,?,?);";
    public static final String INSERT_STUDENT = "INSERT INTO student(student_name) VALUES (?);";


    public boolean addSubject(String subject_name, String subjects_description) throws ClassNotFoundException {

        LOGGER.info("adding Subject " + subject_name + " to DB SQL");

        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUBJECT)) {

            preparedStatement.setString(1, subject_name);
            preparedStatement.setString(2, subjects_description);
            LOGGER.info("Subject " + subject_name + "was add to DB SQL");
            return preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error("adding Subject " + subject_name + " to DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean addGroup(String group_name) throws ClassNotFoundException {

        LOGGER.info("adding Group " + group_name + " to DB SQL");

        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GROUP)) {

            preparedStatement.setString(1, group_name);
            LOGGER.info("Group " + group_name + "was add to DB SQL");
            return preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error("adding Group " + group_name + " to DB SQL was itterupt", e);
            return false;

        }

    }

    public boolean addTeacher(String teacher_name, int experience, int subject_id) throws ClassNotFoundException {

        LOGGER.info("adding Teacher " + teacher_name + " to DB SQL");

        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER)) {

            preparedStatement.setString(1, teacher_name);
            preparedStatement.setInt(2, experience);
            preparedStatement.setInt(3, subject_id);
            LOGGER.info("Teacher " + teacher_name + "was add to DB SQL");
            return preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error("adding Teacher " + teacher_name + " to DB SQL was itterupt", e);
            return false;

        }

    }

    public boolean addStudent(String student_name) throws ClassNotFoundException {

        LOGGER.info("adding Student " + student_name + " to DB SQL");

        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {

            preparedStatement.setString(1, student_name);
            LOGGER.info("Student " + student_name + "was add to DB SQL");
            return preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error("adding Student " + student_name + " to DB SQL was itterupt", e);
            return false;

        }

    }

}
