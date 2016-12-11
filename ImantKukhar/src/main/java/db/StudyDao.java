package db;

import model.Study;
import utils.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Imant on 30.11.16.
 */
public class StudyDao {

    private static StudyDao instance;

    private static final String ADD_NEW_STUDY_PREPARED_STATEMENT = "INSERT INTO studying (group_id, subject_id) VALUES (?, ?)";
    private static final String DELETE_STUDY_PREPARED_STATEMENT = "DELETE FROM studying WHERE group_id = ?";


    public static StudyDao getInstance() {
        if (instance == null)
            instance = new StudyDao();
        return instance;
    }

    public boolean addNewStudy(Study study) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     ADD_NEW_STUDY_PREPARED_STATEMENT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, study.getGroup().getId());
            preparedStatement.setInt(2, study.getSubject().getId());
            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteStudy(Study study) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDY_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, study.getGroup().getId());
            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
