package db;

import converter.ResultSetToUpdatedIdConverter;
import converter.ResultSetToObjectConverter;
import converter.ResultSetToObjectListConverter;
import model.Group;
import model.Student;
import utils.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class StudentDao {

    private static StudentDao instance;

    public static final String ADD_STUDENT_PREPARED_STATEMENT = "INSERT INTO students (student_Name, group_id) VALUES (?, ?)";
    public static final String DELETE_STUDENT_PREPARED_STATEMENT = "DELETE FROM students WHERE id = ?";
    public static final String GET_STUDENT_PREPARED_STATEMENT = "SELECT students.id, students.student_Name, students.group_id, " +
            "groups.group_Name FROM students LEFT JOIN groups ON students.group_id = groups.id WHERE students.id = ?";
    public static final String EDIT_STUDENT_PREPARED_STATEMENT = "UPDATE students SET student_Name = ?, group_id = ? WHERE id = ?";
    public static final String GET_STUDENTS_LIST = "SELECT students.id, students.student_Name, students.group_id, groups.group_Name " +
            "FROM students INNER JOIN groups ON students.group_id = groups.id LIMIT ? OFFSET ?";
    public static final String GET_STUDENTS_LIST_BY_GROUP = "SELECT students.id, students.student_Name, students.group_id, " +
            "groups.group_Name FROM students INNER JOIN groups ON students.group_id = groups.id WHERE students.group_id = ?";


    public static StudentDao getInstance() {
        if (instance == null)
            instance = new StudentDao();
        return instance;
    }

    public boolean addNewStudent(Student student) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (ADD_STUDENT_PREPARED_STATEMENT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getGroup().getId());
            preparedStatement.execute();

            int updatedId = ResultSetToUpdatedIdConverter.getUpdatedIdByResultSet(preparedStatement.getGeneratedKeys());
            if (updatedId != 0) {
                student.setId(updatedId);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(Student student) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, student.getId());
            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Student getStudent(Student student) {
        Student gettingStudent = new Student();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (GET_STUDENT_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, student.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            gettingStudent = ResultSetToObjectConverter.convertResultSetToStudent(resultSet);

            System.out.println(gettingStudent.toString());
            //перевірка на null

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gettingStudent;
    }

    public boolean editStudent(Student updatedStudent) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_STUDENT_PREPARED_STATEMENT)) {

            preparedStatement.setString(1, updatedStudent.getName());
            preparedStatement.setInt(2, updatedStudent.getGroup().getId());
            preparedStatement.setInt(3, updatedStudent.getId());

            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Student> getStudentsList(int limit, int offset) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENTS_LIST)) {

            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();
            return ResultSetToObjectListConverter.getStudentsListFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Student> returnSmth = new ArrayList<>();
        return returnSmth;
    }

    public List<Student> getStudentsListByGroup(Group group) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENTS_LIST_BY_GROUP)) {

            preparedStatement.setInt(1, group.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            return ResultSetToObjectListConverter.getStudentsListFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Student> returnSmth = new ArrayList<>();
        return returnSmth;
    }
}
