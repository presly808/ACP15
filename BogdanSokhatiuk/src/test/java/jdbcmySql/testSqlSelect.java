package jdbcmySql;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * Created by lost on 12.11.2016.
 */
public class testSqlSelect {
    Connection connection;

    @Before
    public void setUp() {
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
