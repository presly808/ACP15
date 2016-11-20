package jdbcmySql.dbMySql;

import jdbcmySql.utils.PropertiesHolder;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by lost on 12.11.2016.
 */
public class JdbcBushIpml implements JdbcBush {
    private static final Logger LOG = Logger.getLogger(PropertiesHolder.class);
    private Connection connection;

    public JdbcBushIpml() {
        connection = SqlConnection.getConnect();
    }

    @Override
    public ResultSet sqlSelect(String sql) throws SQLException {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            LOG.debug("Execute sql " + sql + ";");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error(e);
        }
        return resultSet;
    }

    @Override
    public boolean sqlDeleteUpdateInsert(String sql) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            LOG.debug("Execute sql " + sql + ";");
        } catch (SQLException e) {
            LOG.error(e);
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
        LOG.debug("Close connection");
    }


}
