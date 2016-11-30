package ua.artcode.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by work on 12.11.2016.
 */

public class ConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class);

    public static Connection getConnectionToDBUniversity() throws SQLException {

        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
            LOGGER.info("getting driver to Connection To DB SQL named University on SQL server" + PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            LOGGER.info("get Connection To DB SQL named University on SQL server was interrupt", e);
        }

        Connection connectionToDBUniversity = DriverManager.getConnection(PropertiesHolder.getProperty("URL_JDBC_UNIVERSITY"),
                PropertiesHolder.getProperty("USER"), PropertiesHolder.getProperty("PASSWORD"));

        return connectionToDBUniversity;
    }

    public static Connection getConnectionToTestDB() throws SQLException {

        try {
            Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
            LOGGER.info("getting driver to Connection To DB SQL named Test on SQL server " + PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        } catch (ClassNotFoundException e) {
            LOGGER.info("get Connection To DB SQL named testDBForUniversity on SQL server was interrupt", e);
        }

        Connection connectionToNewDB = DriverManager.getConnection(PropertiesHolder.getProperty("URL_JDBC_TESTDBFORUNIVERSITY"),
                PropertiesHolder.getProperty("USER"), PropertiesHolder.getProperty("PASSWORD"));

        return connectionToNewDB;
    }

}

