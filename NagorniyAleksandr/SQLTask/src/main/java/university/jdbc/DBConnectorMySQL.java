package university.jdbc;

import university.container.PropertiesHolder;

import java.sql.*;


public class DBConnectorMySQL implements DBConnector {

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(PropertiesHolder.get("JDBC_DRIVER_CLASS_NAME"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver Class not found");
        }

        return DriverManager.getConnection(
                PropertiesHolder.get("JDBC_URL"),
                PropertiesHolder.get("JDBC_USER"),
                PropertiesHolder.get("JDBC_PASS"));

        //PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name,birth,phone,amount) VALUES (?,?,?,?)");){

            /*
            preparedStatement.setString(1,);
            preparedStatement.setDate(2,);
            preparedStatement.setString(3,);
            preparedStatement.setDouble(4,);
            */
    }
}

