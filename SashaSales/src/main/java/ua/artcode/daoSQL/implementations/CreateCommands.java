package ua.artcode.daoSQL.implementations;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.CreateDAO;
import ua.artcode.util.ConnectionFactory;
import ua.artcode.util.PropertiesHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by work on 13.11.2016.
 */
public class CreateCommands implements CreateDAO{

    private static final Logger LOGGER = Logger.getLogger(CreateCommands.class);
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

    public CreateCommands() {
    }

    public boolean createTableGroups() {

        LOGGER.info("creating Table Groups in DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_GROUPS);) {
            preparedStatement.execute();
            LOGGER.info("Table Groups was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Groups in DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean createTableSubject() {

        LOGGER.info("creating Table Subjects in DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_SUBJECTS);) {
            preparedStatement.execute();
            LOGGER.info("Table Subjects was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Subjects in DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean createTableTeachers() {

        LOGGER.info("creating Table Teachers in DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_TEACHERS);) {
            preparedStatement.execute();
            LOGGER.info("Table Teachers was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Teachers in DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean createTableStudents() {

        LOGGER.info("creating Table Students in DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_STUDENTS);) {
            preparedStatement.execute();
            LOGGER.info("Table Students was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Students in DB SQL was itterupt", e);
            return false;
        }

    }

    public boolean createTableStudy() {

        LOGGER.info("creating Table Study in DB SQL");

        try(Connection connection = ConnectionFactory.getConnectionToTestDB();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_STUDY);) {
            preparedStatement.execute();
            LOGGER.info("Table Study was create in DB SQL");
            return true;
        } catch (SQLException e) {
            LOGGER.error("creating Table Study in DB SQL was itterupt", e);
            return false;
        }

    }

}
