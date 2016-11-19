package jdbcmySql;

import org.apache.log4j.Logger;
import jdbcmySql.PropertiesHolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lost on 12.11.2016.
 */
public class SqlConnection implements MyConnection {
    private String url;
    private String user;
    private String pass;
    private Logger logger;
    private Connection connection;

    public SqlConnection() {
        url = PropertiesHolder.getProperty("URL");
        user = PropertiesHolder.getProperty("USER");
        pass = PropertiesHolder.getProperty("PASS");
    }
    @Override
    public Connection getConnection() {

        try {connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
