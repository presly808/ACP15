package db;

import converter.ResultSetToUpdatedIdConverter;
import converter.ResultSetToObjectConverter;
import converter.ResultSetToObjectListConverter;
import model.Teacher;
import utils.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class TeacherDao {

    private static TeacherDao instance;

    public static final String ADD_NEW_TEACHER_PREPARED_STATEMENT = "INSERT INTO teachers (teacher_Name, experience, subject_id) VALUES (?, ?, ?)";
    public static final String DELETE_TEACHER_PREPARED_STATEMENT = "DELETE FROM teachers WHERE id = ?";
    public static final String GET_TEACHER_PREPARED_STATEMENT = "SELECT teachers.id, teachers.teacher_Name, teachers.experience, " +
            "subjects.id, subjects.subject_Name, subjects.description FROM teachers INNER JOIN subjects " +
            "ON teachers.subject_id = subjects.id WHERE teachers.id = ?;";
    public static final String EDIT_TEACHER_PREPARED_STATEMENT = "UPDATE teachers SET teacher_Name = ?, experience = ? WHERE id = ?";
    public static final String GET_TEACHERS_LIST = "SELECT teachers.id, teachers.teacher_Name, teachers.experience, subjects.id, " +
            "subjects.subject_Name, subjects.description FROM teachers RIGHT JOIN subjects ON teachers.subject_id = subjects.id " +
            "LIMIT ? OFFSET ?";
    public static final String GET_TEACHER_WITH_MAX_EXPERIENCE = "SELECT teachers.id, teachers.teacher_Name, teachers.experience, " +
            "subjects.id, subjects.subject_Name, subjects.description FROM teachers RIGHT JOIN subjects " +
            "ON teachers.subject_id = subjects.id ORDER BY experience DESC LIMIT 1 OFFSET 0";
    public static final String GET_TEACHER_WITH_MIN_EXPERIENCE = "SELECT teachers.id, teachers.teacher_Name, teachers.experience, " +
            "subjects.id, subjects.subject_Name, subjects.description FROM teachers RIGHT JOIN subjects " +
            "ON teachers.subject_id = subjects.id ORDER BY experience ASC LIMIT 1 OFFSET 0";
    public static final String GET_TEACHERS_LIST_WITH_EXPERIENCE_MORE_THAN_YEARS = "SELECT teachers.id, teachers.teacher_Name, teachers.experience, " +
            "subjects.id, subjects.subject_Name, subjects.description FROM teachers RIGHT JOIN subjects ON " +
            "teachers.subject_id = subjects.id WHERE teachers.experience > ? LIMIT ? OFFSET ?";


    public static TeacherDao getInstance() {
        if (instance == null)
            instance = new TeacherDao();
        return instance;
    }

    public boolean addNewTeacher(Teacher teacher) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     ADD_NEW_TEACHER_PREPARED_STATEMENT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setInt(2, teacher.getExperience());
            preparedStatement.setInt(3, teacher.getSubject().getId());
            preparedStatement.execute();

            int updatedId = ResultSetToUpdatedIdConverter.getUpdatedIdByResultSet(preparedStatement.getGeneratedKeys());
            if (updatedId != 0) {
                teacher.setId(updatedId);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTeacher(Teacher teacher) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TEACHER_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, teacher.getId());
            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Teacher getTeacher(Teacher teacher) {
        Teacher gettingTeacher = new Teacher();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_TEACHER_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, teacher.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            gettingTeacher = ResultSetToObjectConverter.convertResultSetToTeacher(resultSet);

            System.out.println(gettingTeacher.toString());
            //перевірка на null

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gettingTeacher;
    }

    public boolean editTeacher(Teacher updatedTeacher) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_TEACHER_PREPARED_STATEMENT)) {

            preparedStatement.setString(1, updatedTeacher.getName());
            preparedStatement.setInt(2, updatedTeacher.getExperience());
            preparedStatement.setInt(3, updatedTeacher.getId());

            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Teacher> getTeachersList(int limit, int offset) {
        List<Teacher> resultList = new ArrayList<>();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_TEACHERS_LIST)) {

            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultList = ResultSetToObjectListConverter.getTeachersAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public Teacher getTeacherWithMaxExperience(){
        Teacher teacher = new Teacher();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_TEACHER_WITH_MAX_EXPERIENCE)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            teacher = ResultSetToObjectConverter.convertResultSetToTeacher(resultSet);
            return teacher;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public Teacher getTeacherWithMinExperience(){
        Teacher teacher = new Teacher();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_TEACHER_WITH_MIN_EXPERIENCE)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            teacher = ResultSetToObjectConverter.convertResultSetToTeacher(resultSet);
            return teacher;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public List<Teacher> getTeacherListWithExperienceMoreThanYears(int yearsValue, int limit, int offset) {
        List<Teacher> resultList = new ArrayList<>();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_TEACHERS_LIST_WITH_EXPERIENCE_MORE_THAN_YEARS)) {

            preparedStatement.setInt(1, yearsValue);
            preparedStatement.setInt(2, limit);
            preparedStatement.setInt(3, offset);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultList = ResultSetToObjectListConverter.getTeachersAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
