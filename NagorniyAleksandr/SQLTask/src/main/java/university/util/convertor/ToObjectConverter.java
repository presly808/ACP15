package university.util.convertor;

import university.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToObjectConverter {

    public static Student getOneStudentFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int studentId = resultSet.getInt("studentId");
            String studentName = resultSet.getString("studentName");
            int groupId = resultSet.getInt("studentGroupId");
            String groupName = resultSet.getString("groupName");

            return new Student(studentId, studentName, new Group(groupId, groupName));
        } else {
            return null;
        }
    }

    public static Group getOneGroupFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int groupId = resultSet.getInt("groupId");
            String groupName = resultSet.getString("groupName");

            return new Group(groupId, groupName);
        } else {
            return null;
        }
    }

    public static Teacher getOneTeacherFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int teacherId = resultSet.getInt("teacherId");
            String teacherName = resultSet.getString("teacherName");
            int teacherExperience = resultSet.getInt("teacherExperience");

            return new Teacher(teacherId, teacherName, teacherExperience);
        } else {
            return null;
        }
    }


    public static Subject getOneSubjectFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int subjectId = resultSet.getInt("subjectId");
            String subjectName = resultSet.getString("subjectName");
            int categoryId = resultSet.getInt("subjectCategoryId");
            String categoryTitle = resultSet.getString("categoryTitle");
            String subjectDescription = resultSet.getString("subjectDescription");

            return new Subject(subjectId, subjectName, new SubjectCategory(categoryId, categoryTitle), subjectDescription);
        } else {
            return null;
        }
    }

    public static List<Student> getStudentsAsListFromResultSet(ResultSet resultSet) throws SQLException {

        List<Student> result = new ArrayList<>();

        while (resultSet.next()) {

            int studentId = resultSet.getInt("studentId");
            String studentName = resultSet.getString("studentName");
            int groupId = resultSet.getInt("studentGroupId");
            String groupName = resultSet.getString("groupName");

            result.add(new Student(studentId, studentName,
                    new Group(groupId, groupName)));
        }

        return result;
    }

    public static List<Subject> getSubjectsAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Subject> result = new ArrayList<>();

        while (resultSet.next()) {

            int subjectId = resultSet.getInt(1);
            String subjectName = resultSet.getString(2);
            int categoryID = resultSet.getInt(3);
            String categoryTitle = resultSet.getString(4);
            String subjectDescription = resultSet.getString(5);

            result.add(new Subject(subjectId, subjectName,
                    new SubjectCategory(categoryID, categoryTitle),
                    subjectDescription));
        }

        return result;
    }

    public static List<Group> getGroupsAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Group> result = new ArrayList<>();

        while (resultSet.next()) {

            int groupId = resultSet.getInt("groupId");
            String groupName = resultSet.getString("groupName");

            result.add(new Group(groupId, groupName));
        }

        return result;
    }

    public static List<Teacher> getTeachersAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Teacher> result = new ArrayList<>();

        while (resultSet.next()) {

            int teacherId = resultSet.getInt("teacherId");
            String teacherName = resultSet.getString("teacherName");
            int teacherExperience = resultSet.getInt("teacherExperience");

            result.add(new Teacher(teacherId, teacherName, teacherExperience));
        }

        return result;
    }
}
