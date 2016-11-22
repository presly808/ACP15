package university.dao;

import org.apache.log4j.Logger;
import university.dao.crud.CRUDQuery;
import university.exceptions.AppDBException;
import university.jdbc.DBConnector;
import university.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static university.container.TableColumnAliasContainer.getColumnAlias;
import static university.util.convertor.ToObjectConverter.*;

public class QueryCreatorImpl implements QueryCreator {

    private CRUDQuery crudQuery;
    private DBConnector dbConnector;

    private static final Logger log = Logger.getLogger(QueryCreatorImpl.class);

    public QueryCreatorImpl(DBConnector dbConnector, CRUDQuery crudQuery) {
        this.crudQuery = crudQuery;
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT students.id AS ?, students.name AS ?, students.group_id AS ?, groups.name AS ? " +
                             "FROM students " +
                             "LEFT JOIN groups " +
                             "ON students.group_id = groups.id " +
                             "LIMIT ? OFFSET ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("students.id"));
            preparedStatement.setString(i++, getColumnAlias("students.name"));
            preparedStatement.setString(i++, getColumnAlias("students.group_id"));
            preparedStatement.setString(i++, getColumnAlias("groups.name"));

            preparedStatement.setInt(i++, length);
            preparedStatement.setInt(i++, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getStudentsAsListFromResultSet(resultSet);

        } catch (SQLException e) {
            log.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Subject> getSubjectsList(int offset, int length) throws AppDBException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT subjects.id AS ?, subjects.name AS ?, subjects.category_id AS ?, " +
                             "subject_categorys.title AS ?, subjects.description AS ? " +
                             "FROM subjects " +
                             "LEFT JOIN subject_categorys " +
                             "ON subjects.category_id=subject_categorys.id " +
                             "LIMIT ? " +
                             "OFFSET ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("subjects.id"));
            preparedStatement.setString(i++, getColumnAlias("subjects.name"));
            preparedStatement.setString(i++, getColumnAlias("subjects.category_id"));
            preparedStatement.setString(i++, getColumnAlias("subject_categorys.title"));
            preparedStatement.setString(i++, getColumnAlias("subjects.description"));

            preparedStatement.setInt(i++, length);
            preparedStatement.setInt(i++, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getSubjectsAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT groups.id AS ?, groups.name AS ? " +
                             "FROM groups " +
                             "LIMIT ? " +
                             "OFFSET ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("groups.id"));
            preparedStatement.setString(i++, getColumnAlias("groups.name"));

            preparedStatement.setInt(i++, length);
            preparedStatement.setInt(i++, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getGroupsAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length) throws AppDBException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT teachers.id AS ?, teachers.name AS ?, teachers.experience AS ? " +
                             "FROM teachers " +
                             "LIMIT ? " +
                             "OFFSET ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("teachers.id"));
            preparedStatement.setString(i++, getColumnAlias("teachers.name"));
            preparedStatement.setString(i++, getColumnAlias("teachers.experience"));

            preparedStatement.setInt(i++, length);
            preparedStatement.setInt(i++, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getTeachersAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT students.id AS ?, students.name AS ? FROM students WHERE students.group_id = ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("students.id"));
            preparedStatement.setString(i++, getColumnAlias("students.name"));

            preparedStatement.setInt(i++, group.getId());


            preparedStatement.setInt(1, group.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            return getStudentsAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT groups.id AS ?, groups.name AS ? " +
                             "FROM groups " +
                             "INNER JOIN study " +
                             "ON groups.id = study.group_id " +
                             "WHERE study.subject_id = ? " +
                             "LIMIT ? " +
                             "OFFSET ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("groups.id"));
            preparedStatement.setString(i++, getColumnAlias("groups.name"));

            preparedStatement.setInt(i++, subject.getId());
            preparedStatement.setInt(i++, length);
            preparedStatement.setInt(i++, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getGroupsAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Subject> getSubjectsThatStudyAllGroups() throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT study.subject_id AS ?, subjects.name AS ?, " +
                             "subjects.category_id AS ?, subject_categorys.title AS ? " +
                             "FROM study, groups, subjects, subject_categorys " +
                             "WHERE subject_id = subjects.id AND category_id = subject_categorys.id " +
                             "GROUP BY subject_id " +
                             "HAVING count(DISTINCT group_id) = count(DISTINCT groups.id)")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("study.subject_id"));
            preparedStatement.setString(i++, getColumnAlias("subjects.name"));
            preparedStatement.setString(i++, getColumnAlias("subjects.category_id"));
            preparedStatement.setString(i++, getColumnAlias("subject_categorys.title"));

            ResultSet resultSet = preparedStatement.executeQuery();

            return getSubjectsAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Teacher getTeacherWithMaxExperience() throws AppDBException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT teachers.id AS ?, teachers.name AS ?, teachers.experience AS ? " +
                             "FROM teachers " +
                             "GROUP BY id " +
                             "ORDER BY experience DESC " +
                             "LIMIT 1")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("teachers.id"));
            preparedStatement.setString(i++, getColumnAlias("teachers.name"));
            preparedStatement.setString(i++, getColumnAlias("teachers.experience"));

            ResultSet resultSet = preparedStatement.executeQuery();

            return getOneTeacherFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public Teacher getTeacherWithMinExperience() throws AppDBException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT teachers.id AS ?, teachers.name AS ?, teachers.experience AS ? " +
                             "FROM teachers " +
                             "GROUP BY id " +
                             "ORDER BY experience ASC " +
                             "LIMIT 1")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("teachers.id"));
            preparedStatement.setString(i++, getColumnAlias("teachers.name"));
            preparedStatement.setString(i++, getColumnAlias("teachers.experience"));

            ResultSet resultSet = preparedStatement.executeQuery();

            return getOneTeacherFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage() + "Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws AppDBException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT teachers.id AS ?, teachers.name AS ?, teachers.experience AS ? " +
                             "FROM teachers " +
                             "GROUP BY id " +
                             "HAVING experience > ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("teachers.id"));
            preparedStatement.setString(i++, getColumnAlias("teachers.name"));
            preparedStatement.setString(i++, getColumnAlias("teachers.experience"));

            preparedStatement.setInt(i++, years);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getTeachersAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws AppDBException {

        return getTeachersWithExperienceMoreThanYears(3);
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(SubjectCategory category) throws AppDBException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT subjects.id AS ?, subjects.name AS ?, subjects.category_id AS ? " +
                             "FROM subjects " +
                             "WHERE subjects.category_id = ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("subjects.id"));
            preparedStatement.setString(i++, getColumnAlias("subjects.name"));
            preparedStatement.setString(i++, getColumnAlias("subjects.experience"));

            preparedStatement.setInt(i++, category.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            return getSubjectsAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(String categoryName) throws AppDBException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT subjects.id AS ?, subjects.name AS ?, subjects.category_id AS ? " +
                             "FROM subjects " +
                             "INNER JOIN subject_categorys " +
                             "ON subjects.category_id = subject_categorys.id " +
                             "WHERE subject_categorys.title = ?")) {

            int i = 1;
            preparedStatement.setString(i++, getColumnAlias("subjects.id"));
            preparedStatement.setString(i++, getColumnAlias("subjects.name"));
            preparedStatement.setString(i++, getColumnAlias("subjects.experience"));

            preparedStatement.setString(i++, categoryName);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getSubjectsAsListFromResultSet(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage());
            log.error("Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        }
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() throws AppDBException {
        return getListOfSubjectsByCategory("Humanities");
    }

    @Override
    public boolean addStudent(Student student) throws AppDBException {

        return crudQuery.addStudent(student);
    }

    @Override
    public boolean addGroup(Group group) throws AppDBException {

        return crudQuery.addGroup(group);
    }

    @Override
    public boolean addSubject(Subject subject) throws AppDBException {

        return crudQuery.addSubject(subject);
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws AppDBException {

        return crudQuery.addTeacher(teacher);
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws AppDBException {

        return crudQuery.editStudent(studentWithNewData);
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws AppDBException {

        return crudQuery.editGroup(groupWithNewData);
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws AppDBException {

        return crudQuery.editTeacher(teacherWithNewData);
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws AppDBException {

        return crudQuery.editSubject(subjectWithNewData);
    }

    @Override
    public boolean deleteStudent(Student student) throws AppDBException {

        return crudQuery.deleteStudent(student);
    }

    @Override
    public boolean deleteGroup(Group group) throws AppDBException {

        return crudQuery.deleteGroup(group);
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) throws AppDBException {

        return crudQuery.deleteTeacher(teacher);
    }

    @Override
    public boolean deleteSubject(Subject subject) throws AppDBException {

        return crudQuery.deleteSubject(subject);
    }

    @Override
    public Student getStudent(Student student) throws AppDBException {

        return crudQuery.getStudent(student);
    }

    @Override
    public Group getGroup(Group group) throws AppDBException {

        return crudQuery.getGroup(group);
    }

    @Override
    public Teacher getTeacher(Teacher teacher) throws AppDBException {

        return crudQuery.getTeacher(teacher);
    }

    @Override
    public Subject getSubject(Subject subject) throws AppDBException {

        return crudQuery.getSubject(subject);
    }
}