package ua.artcode.daoSQL.implementations;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.SelectDAO;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;
import ua.artcode.util.ConnectionFactory;
import ua.artcode.util.PropertiesHolder;
import ua.artcode.util.UtilsMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 12.11.2016.
 */
public class SelectCommands implements SelectDAO {

    private static final Logger LOGGER = Logger.getLogger(SelectCommands.class);

    private static final String SELECT_ALL_STUDENTS = "SELECT student.id, student.student_name, student.group_id, groups.group_name FROM student, groups WHERE student.group_id=groups.id";
    private static final String SELECT_ALL_GROUPS = "SELECT groups.id, groups.group_name FROM groups";
    private static final String SELECT_ALL_STUDENTS_BY_GROUP = "SELECT student.id, student.student_name, student.group_id, groups.group_name FROM student, groups WHERE student.group_id=groups.id and groups.group_name ='%s'";
    private static final String SELECT_ALL_SUBJECT = "SELECT subjects.id, subjects.subject_name, subjects.description FROM subjects";
    private static final String SELECT_ALL_TEACHERS_THAT_WORK_MORE_3_YEARS = "SELECT teachers.id, teachers.teacher_name, teachers.experience, subjects.subject_name FROM teachers, subjects WHERE teachers.subject_id=subjects.id and teachers.experience > 3";
    private static final String SELECT_ALL_TEACHERS = "SELECT teachers.id, teachers.teacher_name, teachers.experience, subjects.subject_name FROM teachers, subjects WHERE teachers.subject_id=subjects.id";
    private static final String SELECT_GROUPS_THAT_STUDY_SUBJECT = "SELECT groups.id, groups.group_name FROM groups INNER JOIN study INNER JOIN subjects\n" +
            "ON groups.id=study.group_id AND study.subject_id=subjects.id\n" +
            "WHERE subjects.subject_name= ?;";

    private static final String SELECT_AVG_MARK_BY_SUBJECT_IN_UNIVERSITY = "SELECT avg(mark) as middleMark FROM marks INNER JOIN subjects\n" +
            "ON marks.subject_id=subjects.id WHERE subjects.subject_name=?";

    private static final String SELECT_AVG_MARK_BY_SUBJECT_IN_GROUP = "SELECT avg(mark) as middleMark FROM groups INNER JOIN study INNER JOIN marks INNER JOIN subjects\n" +
            "ON groups.id=study.group_id AND study.subject_id=marks.subject_id AND marks.subject_id=subjects.id\n" +
            "WHERE groups.group_name = ? AND subjects.subject_name=?;";

    public SelectCommands() {
    }

    public List<Student> getStudents() {

        LOGGER.info("getting List of Students from SQL DB");

        List<Student> students = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENTS)) {
            UtilsMethod.utilResultSet(resultSet, students);

            LOGGER.info("List of Students was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("List of Students don't get from SQL DB", e);
        }

        return students;
    }


    public List<Student> getStudentsByGroup(String nameGroup) {

        LOGGER.info("getting List of Students By Group from SQL DB");

        List<Student> students = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(String.format(SELECT_ALL_STUDENTS_BY_GROUP, nameGroup))) {

            UtilsMethod.utilResultSet(resultSet, students);

            LOGGER.info("List of Students By Group was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("List of Students By Group don't get from SQL DB", e);
        }

        return students;
    }

    public List<Group> getGroups() {

        LOGGER.info("getting List of Subjects from SQL DB");
        List<Group> groups = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(String.format(SELECT_ALL_GROUPS))) {

            while (resultSet.next()) {
                int id_group = resultSet.getInt("id");
                String name_group = resultSet.getString("group_name");
                Group group = new Group(id_group, name_group);
                groups.add(group);
            }
            LOGGER.info("List of Subjects was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("List of Subjects don't get from SQL DB", e);
        }
        return groups;
    }


    public List<Subject> getSubjects() {

        LOGGER.info("getting List of Teachers from SQL DB");

        List<Subject> subjects = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SUBJECT)) {

            while (resultSet.next()) {
                int subjects_id = resultSet.getInt("id");
                String subjects_name = resultSet.getString("subject_name");
                String subjects_description = resultSet.getString("description");
                Subject subject = new Subject(subjects_id, subjects_name, subjects_description);
                subjects.add(subject);
            }
            LOGGER.info("List of Teachers was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("List of Teachers don't get from SQL DB", e);
        }

        return subjects;
    }

    public List<Teacher> getTeachers() {

        LOGGER.info("getting List of Teachers from SQL DB");
        List<Teacher> teachers = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_TEACHERS)) {

            while (resultSet.next()) {
                int teachers_id = resultSet.getInt("id");
                String teacher_name = resultSet.getString("teacher_name");
                int teacher_experience = resultSet.getInt("experience");
                String subject_name = resultSet.getString("subject_name");
                Subject subject = new Subject(subject_name);
                Teacher teacher = new Teacher(teachers_id, teacher_name, teacher_experience, subject);
                teachers.add(teacher);
            }
            LOGGER.info("List of Teachers was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("List of Teachers don't get from SQL DB", e);
        }

        return teachers;
    }

    public List<Teacher> getTeachersThatWorkMore3Years() {

        LOGGER.info("getting List of Teachers That Work More 3 Years from SQL DB");
        List<Teacher> teachers = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_TEACHERS_THAT_WORK_MORE_3_YEARS)) {

            while (resultSet.next()) {
                int teachers_id = resultSet.getInt("id");
                String teacher_name = resultSet.getString("teacher_name");
                int teacher_experience = resultSet.getInt("experience");
                String subject_name = resultSet.getString("subject_name");
                Subject subject = new Subject(subject_name);
                Teacher teacher = new Teacher(teachers_id, teacher_name, teacher_experience, subject);
                teachers.add(teacher);
            }
            LOGGER.info("List of Teachers That Work More 3 was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("getting List of Teachers That Work More 3 from SQL DB was iterrupt", e);
        }

        return teachers;
    }

    public List<Group> getGroupsThatStudySubject(String subject_name) {

        LOGGER.info("getting List of Groups That Study Subject " + subject_name +" from SQL DB");
        List<Group> groups = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GROUPS_THAT_STUDY_SUBJECT);) {

            preparedStatement.setString(1, subject_name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int group_id = resultSet.getInt("id");
                String group_name = resultSet.getString("group_name");
                Group group = new Group(group_id, group_name);
                groups.add(group);
            }
            resultSet.close();
            LOGGER.info("List of Groups That Study Subject " + subject_name +" from SQL DB was get");
        } catch (SQLException e) {
            LOGGER.error("getting List of Groups That Study Subject " + subject_name +" from SQL DB was iterrupt", e);
        }

        return groups;
    }


    public double avgMarkBySubjectInUniversity(String subject_name) {

        LOGGER.info("getting avg Mark By Subject " + subject_name + " In University ");
        double avgMark = 0;

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AVG_MARK_BY_SUBJECT_IN_UNIVERSITY);) {

            preparedStatement.setString(1, subject_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                avgMark = resultSet.getDouble("middleMark");
            }

            resultSet.close();
            LOGGER.info("getting avg Mark By Subject " + subject_name + " In University was get");
        } catch (SQLException e) {
            LOGGER.error("getting avg Mark By Subject " + subject_name + " In University was iterrupt", e);
        }

        return avgMark;
    }

    public double avgMarkBySubjectInGroup(String group_name, String subject_name) {

        LOGGER.info("getting avg Mark By Subject " + subject_name + " In Group ");
        double avgMark = 0;

        try (Connection connection = ConnectionFactory.getConnectionToTestDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AVG_MARK_BY_SUBJECT_IN_GROUP);) {

            preparedStatement.setString(1, group_name);
            preparedStatement.setString(2, subject_name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                avgMark = resultSet.getDouble("middleMark");
            }
            resultSet.close();
            LOGGER.info("getting avg Mark By Subject " + subject_name + " In Group was get");
        } catch (SQLException e) {
            LOGGER.error("getting avg Mark By Subject " + subject_name + " In Group was iterrupt", e);
        }

        return avgMark;
    }


}
