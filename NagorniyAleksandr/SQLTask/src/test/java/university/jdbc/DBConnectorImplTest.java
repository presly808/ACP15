package university.jdbc;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by aleksandrnagorniy on 18.11.16.
 */
public class DBConnectorImplTest {

    DBConnector dbConnector = new DBConnectorImpl();

    @Test
    public void getConnection() throws Exception {

        try (Connection connection = dbConnector.getConnection()) {
            assertNotNull(connection);
        }
    }
}