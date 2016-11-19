package jdbcmySql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lost on 12.11.2016.
 */
public interface JdbcBush {
    ResultSet sqlSelect(String sql) throws SQLException;

    boolean sqlDeleteUpdateInsert(String sql) throws SQLException;

    void closeConnection() throws SQLException;


}
