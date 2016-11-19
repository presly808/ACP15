package university.jdbc;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by aleksandrnagorniy on 18.11.16.
 */
public class DBConnectorMySQLTest {

    DBConnector dbConnector = new DBConnectorMySQL();

    @Test
    public void getConnection() throws Exception {

        try (Connection connection = dbConnector.getConnection()) {
            assertNotNull(connection);
        }
    }
}