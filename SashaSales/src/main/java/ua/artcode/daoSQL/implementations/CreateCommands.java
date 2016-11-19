package ua.artcode.daoSQL.implementations;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.CreateDAO;
import ua.artcode.util.ConnectionFactory;
import ua.artcode.util.PropertiesHolder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by work on 13.11.2016.
 */
public class CreateCommands implements CreateDAO{

    private static final Logger LOGGER = Logger.getLogger(CreateCommands.class);

    private static final String CREATE_DB_SQL = "CREATE DATABASE %s";
    public static String PART_URL_DB_SQL;
    private static final String CREATE_TABLE_GROUPS = "create table groups(\n" +
            "  id int PRIMARY KEY AUTO_INCREMENT,\n" +
            "  group_name VARCHAR(40) UNIQUE NOT NULL\n" +
            ");";
    private static final String CREATE_TABLE_SUBJECTS = "create table subjects(\n" +
            "  id int PRIMARY KEY AUTO_INCREMENT,\n" +
            "  subject_name VARCHAR(40) UNIQUE NOT NULL,\n" +
            "  description VARCHAR(500)\n" +
            ");";
    private static final String CREATE_TABLE_TEACHERS = "create table teachers(\n" +
            "  id int PRIMARY KEY AUTO_INCREMENT,\n" +
            "  teacher_name VARCHAR(40) UNIQUE NOT NULL,\n" +
            "  experience INT,\n" +
            "  subject_id int,\n" +
            "  FOREIGN KEY (subject_id) REFERENCES subjects(id)\n" +
            ");";

    private static final String CREATE_TABLE_STUDENTS = "create table student(\n" +
            "  id int PRIMARY KEY AUTO_INCREMENT,\n" +
            "  student_name VARCHAR(40) UNIQUE NOT NULL,\n" +
            "  group_id int,\n" +
            "  FOREIGN KEY (group_id) REFERENCES groups(id)\n" +
            ");";

    private static final String CREATE_TABLE_STUDY = "create table study(\n" +
            "  group_id int,\n" +
            "  FOREIGN KEY (group_id) REFERENCES groups(id),\n" +
            "  subject_id int,\n" +
            "  FOREIGN KEY (subject_id) REFERENCES subjects(id)\n" +
            ");";




    public boolean createDBSQL(String nameDB) {

        LOGGER.info("creating DB SQL " + nameDB + "on SQL server");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            LOGGER.error("creating DB SQL " + nameDB + "on SQL server", e);
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(String.format(CREATE_DB_SQL, nameDB));
            LOGGER.info("DB SQL " + nameDB + "was create on SQL server");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating DB SQL " + nameDB + "on SQL server was itterupt", e);
            return false;
        }

    }

    public boolean createTableGroups() {

        LOGGER.info("creating Table Groups in DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(CREATE_TABLE_GROUPS);
            LOGGER.info("Table Groups was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Groups in DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean createTableSubject() {

        LOGGER.info("creating Table Subjects in DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(CREATE_TABLE_SUBJECTS);
            LOGGER.info("Table Subjects was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Subjects in DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean createTableTeachers() {

        LOGGER.info("creating Table Teachers in DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(CREATE_TABLE_TEACHERS);
            LOGGER.info("Table Teachers was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Teachers in DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean createTableStudents() {

        LOGGER.info("creating Table Students in DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(CREATE_TABLE_STUDENTS);
            LOGGER.info("Table Students was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Students in DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean createTableStudy() {

        LOGGER.info("creating Table Study in DB SQL");
        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            LOGGER.error("creating Table Study in DB SQL", e);
        }

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();) {
            statement.executeUpdate(CREATE_TABLE_STUDY);
            LOGGER.info("Table Study was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Study in DB SQL was itterupt", e);
            return false;
        }

    }

}
