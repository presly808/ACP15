package ua.artcode.daoSQL.implementations;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.DropDAO;
import ua.artcode.util.ConnectionFactory;
import ua.artcode.util.PropertiesHolder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by work on 14.11.2016.
 */
public class DropCommands implements DropDAO {

    private static final Logger LOGGER = Logger.getLogger(DropCommands.class);

    public static final String DROP_DB_SQL = "DROP DATABASE %s;";
    public static final String DROP_TABLE_GROUPS = "DROP TABLE groups;";
    public static final String DROP_TABLE_SUBJECTS = "DROP TABLE subjects;";
    public static final String DROP_TABLE_TEACHERS = "DROP TABLE teachers;";
    public static final String DROP_TABLE_STUDENTS = "DROP TABLE student;";
    public static final String DROP_TABLE_STUDY = "DROP TABLE study;";

    public boolean dropDATABASE(String DB_name) {

        LOGGER.info("droping DATABASE " + DB_name + " from DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(String.format(DROP_DB_SQL, DB_name));
            LOGGER.info("DATABASE " + DB_name + "was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping DATABASE " + DB_name + " from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableGroups() {

        LOGGER.info("droping Table Groups from DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(DROP_TABLE_GROUPS);
            LOGGER.info("Table Groups was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Groups from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableSubjects() {

        LOGGER.info("droping Table Subjects from DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(DROP_TABLE_SUBJECTS);
            LOGGER.info("Table Subjects was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Subjects from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableStudents() {

        LOGGER.info("droping Table Students from DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(DROP_TABLE_STUDENTS);
            LOGGER.info("Table Students was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Students from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableTeachers(){

        LOGGER.info("droping Table Teachers from DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(DROP_TABLE_TEACHERS);
            LOGGER.info("Table Teachers was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Teachers from DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean dropTableStudy() {

        LOGGER.info("droping Table Study from DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(DROP_TABLE_TEACHERS);
            LOGGER.info("Table Study was droped from DB SQL");
            return true;

        } catch (SQLException e) {
            LOGGER.error("droping Table Study from DB SQL was itterupt", e);
            return false;
        }

    }


}
