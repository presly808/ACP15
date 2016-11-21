package university.jdbc;

import org.apache.log4j.Logger;
import university.container.PropertiesHolder;

import java.sql.*;


public class DBConnectorImpl implements DBConnector {

    private static final Logger log = Logger.getLogger(PropertiesHolder.class);

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(PropertiesHolder.get("JDBC_DRIVER_CLASS_NAME"));
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            log.error("Throw: SQLException \"DataBase Driver Class not found\"");
            throw new SQLException("DataBase Driver Class not found");
        }

        return DriverManager.getConnection(
                PropertiesHolder.get("JDBC_URL"),
                PropertiesHolder.get("JDBC_USER"),
                PropertiesHolder.get("JDBC_PASS"));
    }
}

