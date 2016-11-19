package university.dao;

import university.dao.crud.CRUDQuery;
import university.exceptions.*;
import university.jdbc.DBConnector;
import university.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static university.dao.converter.ToObjectConverter.*;

public class QueryCreatorImpl implements QueryCreator {

    private CRUDQuery crudQuery;
    private DBConnector dbConnector;

    public QueryCreatorImpl(DBConnector dbConnector, CRUDQuery crudQuery) {
        this.crudQuery = crudQuery;
        this.dbConnector = dbConnector;
    }

    @Override
    public List<Student> getStudentsList(int offset, int length) throws SQLException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT students.id, students.name, students.group_id, " +
                             "groups.name " +
                             "FROM students " +
                             "LEFT JOIN groups " +
                             "ON students.group_id = groups.id " +
                             "LIMIT ? OFFSET ?")) {

            preparedStatement.setInt(1, length);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getStudentsAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Subject> getSubjectsList(int offset, int length) throws SQLException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT subjects.id, subjects.name, subjects.category_id, " +
                             "subject_categorys.title, subjects.description " +
                             "FROM subjects " +
                             "LEFT JOIN subject_categorys " +
                             "ON subjects.category_id=subject_categorys.id " +
                             "LIMIT ? " +
                             "OFFSET ?")) {

            preparedStatement.setInt(1, length);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getSubjectsAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Group> getGroupList(int offset, int length) throws SQLException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * " +
                             "FROM groups " +
                             "LIMIT ? " +
                             "OFFSET ?")) {

            preparedStatement.setInt(1, length);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getGroupsAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Teacher> getTeachersList(int offset, int length) throws SQLException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * " +
                             "FROM teachers " +
                             "LIMIT ? " +
                             "OFFSET ?")) {

            preparedStatement.setInt(1, length);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getTeachersAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Student> getStudentOfGroup(Group group) throws SQLException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, name FROM students WHERE group_id = ?")) {

            preparedStatement.setInt(1, group.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            return getStudentsAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Group> getGroupsBySubject(Subject subject, int offset, int length) throws SQLException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, name " +
                             "FROM groups " +
                             "INNER JOIN study " +
                             "ON id = study.group_id " +
                             "WHERE subject_id = ? " +
                             "LIMIT ? " +
                             "OFFSET ?")) {

            preparedStatement.setInt(1, subject.getId());
            preparedStatement.setInt(2, length);
            preparedStatement.setInt(3, offset);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getGroupsAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Subject> getSubjectsThatStudyAllGroups() throws SQLException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT subject_id, subjects.name, subjects.category_id, subject_categorys.title " +
                             "FROM study, groups, subjects, subject_categorys " +
                             "WHERE subject_id = subjects.id AND category_id = subject_categorys.id " +
                             "GROUP BY subject_id " +
                             "HAVING count(DISTINCT group_id) = count(DISTINCT groups.id)")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return getSubjectsAsListFromResultSet(resultSet);
        }
    }

    @Override
    public Teacher getTeacherWithMaxExperience() throws SQLException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, name, experience " +
                             "FROM teachers " +
                             "GROUP BY id " +
                             "ORDER BY experience DESC " +
                             "LIMIT 1")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return getOneTeacherFromResultSet(resultSet);
        }
    }

    @Override
    public Teacher getTeacherWithMinExperience() throws SQLException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, name, experience " +
                             "FROM teachers " +
                             "GROUP BY id " +
                             "ORDER BY experience ASC " +
                             "LIMIT 1")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return getOneTeacherFromResultSet(resultSet);
        }
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanYears(int years) throws SQLException {

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, name, experience " +
                             "FROM teachers " +
                             "GROUP BY id " +
                             "HAVING experience > ?")) {

            preparedStatement.setInt(1, years);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getTeachersAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Teacher> getTeachersWithExperienceMoreThanThreeYears() throws SQLException {

        return getTeachersWithExperienceMoreThanYears(3);
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(SubjectCategory category) throws SQLException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id, name, category_id " +
                             "FROM subjects " +
                             "WHERE category_id = ?")) {

            preparedStatement.setInt(1, category.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            return getSubjectsAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Subject> getListOfSubjectsByCategory(String categoryName) throws SQLException {
        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT subjects.id, subjects.name, subjects.category_id " +
                             "FROM subjects " +
                             "INNER JOIN subject_categorys " +
                             "ON subjects.category_id = subject_categorys.id " +
                             "WHERE subject_categorys.title = ?")) {

            preparedStatement.setString(1, categoryName);

            ResultSet resultSet = preparedStatement.executeQuery();

            return getSubjectsAsListFromResultSet(resultSet);
        }
    }

    @Override
    public List<Subject> getListOfHumanitarianSubjects() throws SQLException {
        return getListOfSubjectsByCategory("Humanities");
    }

    @Override
    public boolean addStudent(Student student) throws
            SQLException, GroupNotFoundException {

        return crudQuery.addStudent(student);
    }

    @Override
    public boolean addGroup(Group group) throws
            GroupAlreadyExistsException, SQLException {

        return crudQuery.addGroup(group);
    }

    @Override
    public boolean addSubject(Subject subject) throws
            SubjectAlreadyExistsException, SubjectCategoryNotFoundException, SQLException {

        return crudQuery.addSubject(subject);
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws
            SQLException {

        return crudQuery.addTeacher(teacher);
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws
            StudentNotFoundException, GroupNotFoundException, SQLException {

        return crudQuery.editStudent(studentWithNewData);
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws
            GroupNotFoundException, SQLException {

        return crudQuery.editGroup(groupWithNewData);
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws
            TeacherNotFoundException, SQLException {

        return crudQuery.editTeacher(teacherWithNewData);
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws
            SubjectNotFoundException, SubjectCategoryNotFoundException, SQLException {

        return crudQuery.editSubject(subjectWithNewData);
    }

    @Override
    public boolean deleteStudent(Student student) throws
            StudentNotFoundException, SQLException {

        return crudQuery.deleteStudent(student);
    }

    @Override
    public boolean deleteGroup(Group group) throws
            GroupNotFoundException, SQLException {

        return crudQuery.deleteGroup(group);
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) throws
            TeacherNotFoundException, SQLException {

        return crudQuery.deleteTeacher(teacher);
    }

    @Override
    public boolean deleteSubject(Subject subject) throws
            SubjectNotFoundException, SQLException {

        return crudQuery.deleteSubject(subject);
    }

    @Override
    public Student getStudent(Student student) throws
            StudentNotFoundException, SQLException {

        return crudQuery.getStudent(student);
    }


    @Override
    public Group getGroup(Group group) throws
            GroupNotFoundException, SQLException {

        return crudQuery.getGroup(group);
    }


    @Override
    public Teacher getTeacher(Teacher teacher) throws
            TeacherNotFoundException, SQLException {

        return crudQuery.getTeacher(teacher);
    }

    @Override
    public Subject getSubject(Subject subject) throws
            SubjectNotFoundException, SQLException {

        return crudQuery.getSubject(subject);
    }
}