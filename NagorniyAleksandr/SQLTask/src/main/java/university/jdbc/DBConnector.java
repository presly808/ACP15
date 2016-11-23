package university.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by aleksandrnagorniy on 12.11.16.
 */
public interface DBConnector {

    Connection getConnection() throws SQLException;
}
