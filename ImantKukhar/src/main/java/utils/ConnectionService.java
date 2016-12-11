package utils;

import utils.PropertiesHolder;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Imant on 28.11.16.
 */
public class ConnectionService {

    public static Connection createConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            final String DB_URL = "jdbc:mysql://localhost:3306/university";
            final String DB_USER = "root";
            final String DB_PASS = "1";

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
