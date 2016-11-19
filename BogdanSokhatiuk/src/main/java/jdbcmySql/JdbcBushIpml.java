package jdbcmySql;

import java.sql.*;

/**
 * Created by lost on 12.11.2016.
 */
public class JdbcBushIpml implements JdbcBush {
    private Connection connection;

    public JdbcBushIpml() {
        SqlConnection sqlConnection = new SqlConnection();
        connection = sqlConnection.getConnection();
    }

    @Override
    public ResultSet sqlSelect(String sql) throws SQLException {
        ResultSet resultSet = null;
        try  {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();}
        return resultSet;
    }

    @Override
    public boolean sqlDeleteUpdateInsert(String sql) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }



}
