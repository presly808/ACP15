package university.dao.converter;

import university.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToObjectConverter {

    public static Student getOneStudentFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int studentId = resultSet.getInt(1);
            String studentName = resultSet.getString(2);
            int groupId = resultSet.getInt(3);
            String groupName = resultSet.getString(4);

            return new Student(studentId, studentName, new Group(groupId, groupName));
        } else {
            return null;
        }
    }

    public static Group getOneGroupFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int groupId = resultSet.getInt("id");
            String groupName = resultSet.getString("name");

            return new Group(groupId, groupName);
        } else {
            return null;
        }
    }

    public static Teacher getOneTeacherFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int teacherId = resultSet.getInt("id");
            String teacherName = resultSet.getString("name");
            int teacherExperience = resultSet.getInt("experience");

            return new Teacher(teacherId, teacherName, teacherExperience);
        } else {
            return null;
        }
    }

    public static Subject getOneSubjectFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int subjectId = resultSet.getInt("id");
            String subjectName = resultSet.getString("name");
            int categoryId = resultSet.getInt("category_id");
            String categoryTitle = resultSet.getString("title");
            String subjectDescription = resultSet.getString("description");

            return new Subject(subjectId, subjectName, new SubjectCategory(categoryId, categoryTitle), subjectDescription);
        } else {
            return null;
        }
    }

    public static List<Student> getStudentsAsListFromResultSet(ResultSet resultSet) throws SQLException {

        List<Student> result = new ArrayList<>();

        while (resultSet.next()) {

            int studentId = resultSet.getInt(1);
            String studentName = resultSet.getString(2);
            int groupId = resultSet.getInt(3);
            String groupName = resultSet.getString(4);

            result.add(new Student(studentId, studentName,
                    new Group(groupId, groupName)));
        }

        return result;
    }

    public static List<Subject> getSubjectsAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Subject> result = new ArrayList<>();

        while (resultSet.next()) {

            int subjectId = resultSet.getInt("id");
            String subjectName = resultSet.getString("name");
            int categoryID = resultSet.getInt("category_id");
            String categoryTitle = resultSet.getString("title");
            String subjectDescription = resultSet.getString("description");

            result.add(new Subject(subjectId, subjectName,
                    new SubjectCategory(categoryID, categoryTitle),
                    subjectDescription));
        }

        return result;
    }

    public static List<Group> getGroupsAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Group> result = new ArrayList<>();

        while (resultSet.next()) {

            int groupId = resultSet.getInt("id");
            String groupName = resultSet.getString("name");

            result.add(new Group(groupId, groupName));
        }

        return result;
    }

    public static List<Teacher> getTeachersAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Teacher> result = new ArrayList<>();

        while (resultSet.next()) {

            int teacherId = resultSet.getInt("id");
            String teacherName = resultSet.getString("name");
            int teacherExperience = resultSet.getInt("experience");

            result.add(new Teacher(teacherId, teacherName, teacherExperience));
        }

        return result;
    }


}
