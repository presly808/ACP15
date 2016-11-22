package jdbcmySql;

import jdbcmySql.dbMySql.SqlConnection;
import jdbcmySql.utils.PropertiesHolder;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.log4j.Logger;
import org.junit.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

import static jdbcmySql.model.SqlScripts.*;

/**
 * Created by lost on 12.11.2016.
 */
public class TestSqlSelect {
    private Connection connection;
    private static final Logger LOG = Logger.getLogger(PropertiesHolder.class);

    @BeforeClass
    public static void setUp() throws Exception {
        Connection con = new SqlConnection().getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(con);
        InputStream is = TestJDBCtask.class.getResourceAsStream("/sqlsripts.sql");
        scriptRunner.runScript(new InputStreamReader(is));
    }

    @Before
    public void beforeMethod() {
        SqlConnection sqlConnection = new SqlConnection();
        connection = sqlConnection.getConnection();
    }

    @After
    public void tearDown() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOG.error(e);
        }
    }

    @Test
    public void testSelect() {
        String name = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLTEST1)) {


            while (resultSet.next()) {
                name = resultSet.getString(1);
            }
            Assert.assertEquals(name, "Bogdan");
        } catch (SQLException e) {
            LOG.error(e);
        }

    }


    @Test
    public void testInsert() {
        String name = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLTEST2)) {
            preparedStatement.setInt(1, 111);
            preparedStatement.setString(2, "Viktor");
            preparedStatement.setInt(3, 2);
            preparedStatement.execute();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLTEST3);

            while (resultSet.next()) {
                name = resultSet.getString(1);
            }
            Assert.assertEquals(name, "Viktor");
        } catch (SQLException e) {
            LOG.error(e);
        }


    }

    @Test
    public void testDelete() {
        String name = "";
        Statement statement = null;
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLTEST4)) {
            preparedStatement.execute();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQLTEST5);


            while (resultSet.next()) {
                name = resultSet.getString(1);
            }
            Assert.assertEquals(name, "");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
