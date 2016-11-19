package ua.artcode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by work on 12.11.2016.
 */
public class ConnectionFactory {

    public static Connection getConnectionToDBUniversity() throws SQLException {

        Connection connectionToDBUniversity = DriverManager.getConnection(PropertiesHolder.getProperty("URL_JDBC_UNIVERSITY"),
                PropertiesHolder.getProperty("USER"), PropertiesHolder.getProperty("PASSWORD"));

        return connectionToDBUniversity;
    }

    public static Connection getConnectionToNewDB() throws SQLException {

        String str = IO.read();
        Connection connectionToNewDB = DriverManager.getConnection(PropertiesHolder.getProperty(str),
                PropertiesHolder.getProperty("USER"), PropertiesHolder.getProperty("PASSWORD"));

        return connectionToNewDB;
    }

}
