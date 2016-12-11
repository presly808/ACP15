package db;

import utils.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Imant on 20.11.16.
 */
public class UniversityDao {

    private static UniversityDao instance;

    public static UniversityDao getInstance() {
        if (instance == null)
            instance = new UniversityDao();
        return instance;
    }

    public void createTableByRequest(String request) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillUpTableByRequest(String request) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}