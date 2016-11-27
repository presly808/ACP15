
package ua.artcode.daoSQL.implementationssql;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.DropDAO;
import ua.artcode.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by work on 14.11.2016.
 */

public class DropCommands implements DropDAO {

    private static final Logger LOGGER = Logger.getLogger(DropCommands.class);

    private static final String DROP_TABLE_GROUPS = "DROP TABLE groups;";
    private static final String DROP_TABLE_SUBJECTS = "DROP TABLE subjects;";
    private static final String DROP_TABLE_TEACHERS = "DROP TABLE teachers;";
    private static final String DROP_TABLE_STUDENTS = "DROP TABLE student;";
    private static final String DROP_TABLE_STUDY = "DROP TABLE study;";
    private static final String DROP_TABLE_MARKS = "DROP TABLE marks;";

    public DropCommands() {
    }

    public boolean dropTableGroups() {

        LOGGER.info("droping Table Groups from DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_GROUPS);) {
            preparedStatement.execute();
            LOGGER.info("Table Groups was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Groups from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableSubjects() {

        LOGGER.info("droping Table Subjects from DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_SUBJECTS);) {
            preparedStatement.execute();
            LOGGER.info("Table Subjects was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Subjects from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableStudents() {

        LOGGER.info("droping Table Students from DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_STUDENTS);) {
            preparedStatement.execute();
            LOGGER.info("Table Students was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Students from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableTeachers(){

        LOGGER.info("droping Table Teachers from DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_TEACHERS);) {
            preparedStatement.execute();
            LOGGER.info("Table Teachers was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Teachers from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableStudy() {

        LOGGER.info("droping Table Study from DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_STUDY);) {
            preparedStatement.execute();
            LOGGER.info("Table Study was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Study from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableMarks() {

        LOGGER.info("droping Table Marks from DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_MARKS);) {
            preparedStatement.execute();
            LOGGER.info("Table Marks was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Marks from DB SQL was itterupt", e);
            return false;
        }

    }


}
