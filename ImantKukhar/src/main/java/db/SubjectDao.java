package db;

import converter.ResultSetToUpdatedIdConverter;
import converter.ResultSetToObjectConverter;
import converter.ResultSetToObjectListConverter;
import model.Subject;
import utils.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class SubjectDao {

    private static SubjectDao instance;

    public static final String ADD_NEW_SUBJECT_PREPARED_STATEMENT = "INSERT INTO subjects (subject_Name, description) VALUES (?, ?)";
    public static final String DELETE_SUBJECT_PREPARED_STATEMENT = "DELETE FROM subjects WHERE id = ?";
    public static final String GET_SUBJECT_PREPARED_STATEMENT = "SELECT subjects.id, subject.subject_Name, subjects.description " +
            "FROM subject WHERE subject.id = ?";
    public static final String EDIT_SUBJECT_PREPARED_STATEMENT = "UPDATE subjects SET subjects_Name = ?, description = ? WHERE id = ?";
    public static final String GET_SUBJECTS_LIST = "SELECT subjects.id, subjects.subject_Name, subjects.description " +
            "FROM subjects LIMIT ? OFFSET ?";

    public static SubjectDao getInstance() {
        if (instance == null)
            instance = new SubjectDao();
        return instance;
    }

    public boolean addNewSubject(Subject subject) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     ADD_NEW_SUBJECT_PREPARED_STATEMENT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, subject.getName());
            preparedStatement.setString(2, subject.getDescription());
            preparedStatement.execute();

            int updatedId = ResultSetToUpdatedIdConverter.getUpdatedIdByResultSet(preparedStatement.getGeneratedKeys());
            if (updatedId != 0) {
                subject.setId(updatedId);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSubject(Subject subject) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SUBJECT_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, subject.getId());
            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Subject getSubject(Subject subject) {
        Subject gettingSubject = new Subject();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_SUBJECT_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, subject.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            gettingSubject = ResultSetToObjectConverter.convertResultSetToSubject(resultSet);

            System.out.println(gettingSubject.toString());
            //перевірка на null

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gettingSubject;
    }

    public boolean editSubject(Subject updatedSubject) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_SUBJECT_PREPARED_STATEMENT)) {

            preparedStatement.setString(1, updatedSubject.getName());
            preparedStatement.setString(2, updatedSubject.getDescription());
            preparedStatement.setInt(3, updatedSubject.getId());

            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Subject> getSubjectsList(int limit, int offset) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_SUBJECTS_LIST)) {

            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();
            return ResultSetToObjectListConverter.getSubjectsListFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Subject> returnSmth = new ArrayList<>();
        return returnSmth;
    }
}
