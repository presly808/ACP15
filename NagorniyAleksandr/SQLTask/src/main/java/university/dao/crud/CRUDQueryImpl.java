package university.dao.crud;

import org.apache.log4j.Logger;
import university.exceptions.AppDBException;
import university.jdbc.DBConnector;
import university.models.Group;
import university.models.Student;
import university.models.Subject;
import university.models.Teacher;

import java.sql.*;

import static university.util.convertor.ToObjectConverter.*;

public class CRUDQueryImpl implements CRUDQuery {
    private static final String ADD_STUDENT = "INSERT INTO students (name, group_id) VALUES (?,?)";
    private static final String ADD_GROUP = "INSERT INTO groups (name) VALUES (?)";
    private static final String ADD_SUBJECT = "INSERT INTO subjects(name, category_id, description) " +
            "VALUES (?, ?, ?)";
    private static final String ADD_TEACHER = "INSERT INTO teachers(name, experience) VALUES (?, ?)";
    private static final String UPDATE_STUDENT = "UPDATE students " +
            "SET students.name = ?, students.group_id = ? " +
            "WHERE students.id = ?";
    private static final String UPDATE_GROUP = "UPDATE groups " +
            "SET name = ? " +
            "WHERE id = ?";
    private static final String UPDATE_TEACHER = "UPDATE teachers " +
            "SET name = ?, experience = ? " +
            "WHERE id = ?";
    private static final String UPDATE_SUBJECT = "UPDATE subjects " +
            "SET name = ?, category_id = ?, description = ? " +
            "WHERE id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
    private static final String DELETE_GROUP = "DELETE FROM groups WHERE id = ?";
    private static final String DELETE_TEACHER = "DELETE FROM teachers WHERE id = ?";
    private static final String DELETE_SUBJECT = "DELETE FROM subjects WHERE id = ?";
    private static final String GET_STUDENT = "SELECT students.id AS studentId, " +
            "students.name AS studentName, " +
            "students.group_id AS studentGroupId, " +
            "groups.name AS groupName " +
            "FROM students " +
            "LEFT JOIN groups " +
            "ON students.group_id = groups.id " +
            "WHERE students.id = ?";
    private static final String GET_GROUP = "SELECT groups.id AS groupId, " +
            "groups.name AS groupName " +
            "FROM groups " +
            "WHERE id = ?";
    private static final String GET_TEACHER = "SELECT teachers.id AS teacherId, " +
            "teachers.name AS teacherName, " +
            "teachers.experience AS teacherExperience " +
            "FROM teachers " +
            "WHERE id = ?";
    private static final String GET_SUBJECT = "SELECT subjects.id AS subjectId, " +
            "subjects.name AS subjectName, " +
            "category_id AS subjectCategoryId, " +
            "subject_categorys.title AS categoryTitle, " +
            "subjects.description AS subjectDescription " +
            "FROM subjects " +
            "LEFT JOIN subject_categorys " +
            "ON subjects.category_id = subject_categorys.id " +
            "WHERE subjects.id = ?";

    private DBConnector dbConnector;

    private static final Logger LOGGER = Logger.getLogger(CRUDQueryImpl.class);

    public CRUDQueryImpl(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public boolean addStudent(Student student) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     ADD_STUDENT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getGroup().getId());

            preparedStatement.execute();

            int newStudentId = getGeneratedId(preparedStatement);
            if (newStudentId != 0) {
                student.setId(newStudentId);
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
        return false;
    }

    int getGeneratedId(PreparedStatement preparedStatement) throws SQLException {
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean addGroup(Group group) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     ADD_GROUP, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, group.getName());

            preparedStatement.execute();

            int newGroupId = getGeneratedId(preparedStatement);
            if (newGroupId != 0) {
                group.setId(newGroupId);
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addSubject(Subject subject) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     ADD_SUBJECT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getCategory().getId());
            preparedStatement.setString(3, subject.getDescription());

            preparedStatement.execute();

            int newSubjectId = getGeneratedId(preparedStatement);
            if (newSubjectId != 0) {
                subject.setId(newSubjectId);
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     ADD_TEACHER, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setInt(2, teacher.getExperience());

            preparedStatement.execute();

            int newTeacherId = getGeneratedId(preparedStatement);
            if (newTeacherId != 0) {
                teacher.setId(newTeacherId);
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     UPDATE_STUDENT)) {

            preparedStatement.setString(1, studentWithNewData.getName());
            preparedStatement.setInt(2, studentWithNewData.getGroup().getId());
            preparedStatement.setInt(3, studentWithNewData.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                LOGGER.error("Throw: AppDBException, Student not found");
                throw new AppDBException("Student not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     UPDATE_GROUP)) {

            preparedStatement.setString(1, groupWithNewData.getName());
            preparedStatement.setInt(2, groupWithNewData.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                LOGGER.error("Throw: AppDBException, Group not found");
                throw new AppDBException("Group not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     UPDATE_TEACHER)) {

            preparedStatement.setString(1, teacherWithNewData.getName());
            preparedStatement.setInt(2, teacherWithNewData.getExperience());
            preparedStatement.setInt(3, teacherWithNewData.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                LOGGER.error("Throw: AppDBException, Teacher not found");
                throw new AppDBException("Teacher not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     UPDATE_SUBJECT)) {

            preparedStatement.setString(1, subjectWithNewData.getName());
            preparedStatement.setInt(2, subjectWithNewData.getCategory().getId());
            preparedStatement.setString(3, subjectWithNewData.getDescription());
            preparedStatement.setInt(4, subjectWithNewData.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                LOGGER.error("Throw: AppDBException, Teacher not found");
                throw new AppDBException("Teacher not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean deleteStudent(Student student) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     DELETE_STUDENT)) {

            preparedStatement.setInt(1, student.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                LOGGER.error("Throw: AppDBException, Student not found");
                throw new AppDBException("Student not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean deleteGroup(Group group) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     DELETE_GROUP)) {

            preparedStatement.setInt(1, group.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                LOGGER.error("Throw: AppDBException, Group not found");
                throw new AppDBException("Group not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     DELETE_TEACHER)) {

            preparedStatement.setInt(1, teacher.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                LOGGER.error("Throw: AppDBException, Teacher not found");
                throw new AppDBException("Teacher not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean deleteSubject(Subject subject) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     DELETE_SUBJECT)) {

            preparedStatement.setInt(1, subject.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                LOGGER.error("Throw: AppDBException, Subject not found");
                throw new AppDBException("Subject not found");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Student getStudent(Student student) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     GET_STUDENT)) {

            preparedStatement.setInt(1, student.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Student resStudent = getOneStudentFromResultSet(resultSet);

            if (resStudent == null) {
                LOGGER.error("Throw: AppDBException, Student not found");
                throw new AppDBException("Student not found");
            }
            return resStudent;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Group getGroup(Group group) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     GET_GROUP)) {

            preparedStatement.setInt(1, group.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Group resGroup = getOneGroupFromResultSet(resultSet);

            if (resGroup == null) {
                LOGGER.error("Throw: AppDBException, Group not found");
                throw new AppDBException("Group not found");
            }
            return resGroup;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Teacher getTeacher(Teacher teacher) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     GET_TEACHER)) {


            preparedStatement.setInt(1, teacher.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Teacher resTeacher = getOneTeacherFromResultSet(resultSet);

            if (resTeacher == null) {
                LOGGER.error("Throw: AppDBException, Teacher not found");
                throw new AppDBException("Teacher not found");
            }
            return resTeacher;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Subject getSubject(Subject subject) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     GET_SUBJECT)) {

            preparedStatement.setInt(1, subject.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Subject resSubject = getOneSubjectFromResultSet(resultSet);

            if (resSubject == null) {
                LOGGER.error("Throw: AppDBException, Subject not found");
                throw new AppDBException("Subject not found");
            }
            return resSubject;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }
}