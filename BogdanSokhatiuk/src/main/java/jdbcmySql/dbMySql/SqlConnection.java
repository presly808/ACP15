package jdbcmySql.dbMySql;

import jdbcmySql.utils.PropertiesHolder;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lost on 12.11.2016.
 */
public class SqlConnection implements MyConnection {
    private static final Logger LOG = Logger.getLogger(PropertiesHolder.class);
    private static String url;
    private static String user;
    private static String pass;
    private static Logger logger;
    private static Connection connection;

    public SqlConnection() {
        url = PropertiesHolder.getProperty("URL");
        user = PropertiesHolder.getProperty("USER");
        pass = PropertiesHolder.getProperty("PASS");
    }

    public static Connection getConnect(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
            LOG.debug("Create data base connection " + "Url=" + url + "; User=" + user);
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Connection getConnection() {

        try {

            connection = DriverManager.getConnection(url, user, pass);
            LOG.debug("Create data base connection " + "Url=" + url + "; User=" + user);
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOG.error(e);
            e.printStackTrace();
        }
    }

}
