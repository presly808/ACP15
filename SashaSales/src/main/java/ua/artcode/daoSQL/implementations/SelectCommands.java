package ua.artcode.daoSQL.implementations;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.interfaces.SelectDAO;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;
import ua.artcode.service.IServiceImpl;
import ua.artcode.util.ConnectionFactory;
import ua.artcode.util.PropertiesHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 12.11.2016.
 */
public class SelectCommands implements SelectDAO {

    private static final Logger LOGGER = Logger.getLogger(SelectCommands.class);

    public static final String SELECT_ALL_STUDENTS = "SELECT student.id, student.student_name, student.group_id, groups.group_name FROM student, groups WHERE student.group_id=groups.id";
    public static final String SELECT_ALL_GROUPS = "SELECT groups.id, groups.group_name FROM groups";
    public static final String SELECT_ALL_STUDENTS_BY_GROUP = "SELECT student.id, student.student_name FROM student, groups WHERE student.group_id=groups.id and groups.group_name LIKE '%s'";
    public static final String SELECT_ALL_SUBJECT = "SELECT subjects.id, subjects.subject_name, subjects.description FROM subjects";
    public static final String SELECT_ALL_TEACHERS = "SELECT teachers.id, teachers.teacher_name, teachers.experience, subjects.subject_name FROM teachers, subjects WHERE teachers.subject_id=subjects.id";

    public List<Student> getStudents() throws ClassNotFoundException {

        LOGGER.info("getting List of Students from SQL DB");

        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        List<Student> students =  new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_STUDENTS)) {

                while (resultSet.next()){
                int id_student = resultSet.getInt("id");
                String student_name = resultSet.getString("student_name");
                int id_group = resultSet.getInt("group_id");
                String group_name = resultSet.getString("group_name");
                Group group = new Group(id_group, group_name);
                Student student = new Student(id_student, student_name, group);
                students.add(student);
                }
            LOGGER.info("List of Students was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("List of Students don't get from SQL DB", e);
        }

        return students;
    }

    public List<Student> getStudentsByGroup(String nameGroup) throws ClassNotFoundException {

        LOGGER.info("getting List of Students By Group from SQL DB");

        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        List<Student> students =  new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(SELECT_ALL_STUDENTS_BY_GROUP, nameGroup))) {

            while (resultSet.next()){
                int id_student = resultSet.getInt("id");
                String student_name = resultSet.getString("student_name");
                int id_group = resultSet.getInt("group_id");
                String group_name = resultSet.getString("group_name");
                Group group = new Group(id_group, group_name);
                Student student = new Student(id_student, student_name, group);
                students.add(student);
            }
            LOGGER.info("List of Students By Group was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("List of Students By Group don't get from SQL DB", e);
        }

        return students;
    }

    public List<Group> getGroups() throws ClassNotFoundException {

        LOGGER.info("getting List of Subjects from SQL DB");
        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        List<Group> groups = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(SELECT_ALL_GROUPS))) {

            while (resultSet.next()){
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


    public List<Subject> getSubjects() throws ClassNotFoundException {

        LOGGER.info("getting List of Teachers from SQL DB");
        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        List<Subject> subjects =  new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_SUBJECT)) {

            while (resultSet.next()){
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

    public List<Teacher> getTeachers() throws ClassNotFoundException {

        LOGGER.info("getting List of Groups from SQL DB");
        Class.forName(PropertiesHolder.getProperty("CLASS_NAME_JDBC_DRIVER"));
        List<Teacher> teachers =  new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnectionToNewDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_TEACHERS)) {

            while (resultSet.next()){
                int teachers_id = resultSet.getInt("id");
                String teacher_name = resultSet.getString("teacher_name");
                int teacher_experience = resultSet.getInt("experience");
                String subject_name = resultSet.getString("subject_name");
                Subject subject = new Subject(subject_name);
                Teacher teacher = new Teacher(teachers_id, teacher_name, teacher_experience, subject);
                teachers.add(teacher);
            }
            LOGGER.info("List of Groups was get from SQL DB");
        } catch (SQLException e) {
            LOGGER.error("List of Groups don't get from SQL DB", e);
        }

        return teachers;
    }

}
