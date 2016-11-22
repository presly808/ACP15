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
    private DBConnector dbConnector;

    private static final Logger log = Logger.getLogger(CRUDQueryImpl.class);

    public CRUDQueryImpl(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public boolean addStudent(Student student) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO students(name, group_id) VALUES (?,?)",
                     Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getGroup().getId());

            preparedStatement.execute();

            int newStudentId = getGeneratedId(preparedStatement);
            if (newStudentId != 0) {
                student.setId(newStudentId);
                return true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
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
                     "INSERT INTO groups(name) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, group.getName());

            preparedStatement.execute();

            int newGroupId = getGeneratedId(preparedStatement);
            if (newGroupId != 0) {
                group.setId(newGroupId);
                return true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addSubject(Subject subject) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO subjects(name, category_id, description) VALUES (?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
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
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO teachers(name, experience) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setInt(2, teacher.getExperience());

            preparedStatement.execute();

            int newTeacherId = getGeneratedId(preparedStatement);
            if (newTeacherId != 0) {
                teacher.setId(newTeacherId);
                return true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE students SET name = ?, group_id = ? WHERE id = ?")) {
            preparedStatement.setString(1, studentWithNewData.getName());
            preparedStatement.setInt(2, studentWithNewData.getGroup().getId());
            preparedStatement.setInt(3, studentWithNewData.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                log.error("Throw: AppDBException");
                throw new AppDBException("Student not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE groups SET name = ? WHERE id = ?")) {
            preparedStatement.setString(1, groupWithNewData.getName());
            preparedStatement.setInt(2, groupWithNewData.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                log.error("Throw: AppDBException");
                throw new AppDBException("Group not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE teachers SET name = ?, experience = ? WHERE id = ?")) {
            preparedStatement.setString(1, teacherWithNewData.getName());
            preparedStatement.setInt(2, teacherWithNewData.getExperience());
            preparedStatement.setInt(3, teacherWithNewData.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                log.error("Throw: AppDBException");
                throw new AppDBException("Teacher not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE subjects SET name = ?, category_id = ?, description = ? WHERE id = ?")) {
            preparedStatement.setString(1, subjectWithNewData.getName());
            preparedStatement.setInt(2, subjectWithNewData.getCategory().getId());
            preparedStatement.setString(3, subjectWithNewData.getDescription());
            preparedStatement.setInt(4, subjectWithNewData.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                log.error("Throw: AppDBException");
                throw new AppDBException("Teacher not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean deleteStudent(Student student) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM students WHERE id=?")) {

            preparedStatement.setInt(1, student.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                log.error("Throw: AppDBException");
                throw new AppDBException("Student not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean deleteGroup(Group group) throws
            AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM groups WHERE id=?")) {

            preparedStatement.setInt(1, group.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                log.error("Throw: AppDBException");
                throw new AppDBException("Group not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM teachers WHERE id=?")) {

            preparedStatement.setInt(1, teacher.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                log.error("Throw: AppDBException");
                throw new AppDBException("Teacher not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public boolean deleteSubject(Subject subject) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM subjects WHERE id=?")) {

            preparedStatement.setInt(1, subject.getId());

            if (preparedStatement.executeUpdate() != 0) {
                return true;
            } else {
                log.error("Throw: AppDBException");
                throw new AppDBException("Subject not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Student getStudent(Student student) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT students.id, students.name, students.group_id, groups.name " +
                             "FROM students " +
                             "LEFT JOIN groups " +
                             "ON students.group_id = `groups`.id " +
                             "WHERE students.id = ?")) {

            preparedStatement.setInt(1, student.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Student resStudent = getOneStudentFromResultSet(resultSet);

            if (resStudent == null) {
                log.error("Throw: AppDBException");
                throw new AppDBException("Student not found");
            }
            return resStudent;

        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Group getGroup(Group group) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * " +
                             "FROM groups " +
                             "WHERE id = ?")) {

            preparedStatement.setInt(1, group.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Group resGroup = getOneGroupFromResultSet(resultSet);

            if (resGroup == null) {
                log.error("Throw: AppDBException");
                throw new AppDBException("Group not found");
            }
            return resGroup;

        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Teacher getTeacher(Teacher teacher) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * " +
                             "FROM teachers " +
                             "WHERE id = ?")) {

            preparedStatement.setInt(1, teacher.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Teacher resTeacher = getOneTeacherFromResultSet(resultSet);

            if (resTeacher == null) {
                log.error("Throw: AppDBException");
                throw new AppDBException("Teacher not found");
            }
            return resTeacher;

        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Subject getSubject(Subject subject) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT subjects.id, name, category_id, " +
                             "subject_categorys.title, subjects.description " +
                             "FROM subjects " +
                             "LEFT JOIN `subject_categorys` " +
                             "ON subjects.category_id=`subject_categorys`.id " +
                             "WHERE subjects.id = ?")) {

            preparedStatement.setInt(1, subject.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Subject resSubject = getOneSubjectFromResultSet(resultSet);

            if (resSubject == null) {
                log.error("Throw: AppDBException");
                throw new AppDBException("Subject not found");
            }
            return resSubject;
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }
}