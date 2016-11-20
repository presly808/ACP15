package jdbcmySql;

import jdbcmySql.dbMySql.SqlConnection;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by lost on 12.11.2016.
 */
public class TestSqlSelect {
    Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        Connection con = new SqlConnection().getConnection();
        ScriptRunner scriptRunner= new ScriptRunner(con);
        InputStream is= TestJDBCtask.class.getResourceAsStream("/sqlsripts.sql");
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
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect() {
        String name = "";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT name FROM students where id=11")) {


            while (resultSet.next()) {
                name = resultSet.getString(1);
            }
            Assert.assertEquals(name, "Bogdan");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testInsert() {
        String name = "";
        Statement statement = null;
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students VALUES(?,?,?)")) {
            preparedStatement.setInt(1, 111);
            preparedStatement.setString(2, "Viktor");
            preparedStatement.setInt(3, 2);
            preparedStatement.execute();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT name FROM students where id=111");


            while (resultSet.next()) {
                name = resultSet.getString(1);
            }
            Assert.assertEquals(name, "Viktor");
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

    @Test
    public void testDelete() {
        String name = "";
        Statement statement = null;
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=111")) {
            preparedStatement.execute();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT name FROM students where id=111");


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
