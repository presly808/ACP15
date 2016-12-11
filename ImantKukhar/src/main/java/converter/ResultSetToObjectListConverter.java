package converter;

import model.Group;
import model.Student;
import model.Subject;
import model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class ResultSetToObjectListConverter {

    public static List<Group> getGroupsListFromResultSet(ResultSet resultSet) {
        List<Group> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int groupId = resultSet.getInt(1);
                String groupName = resultSet.getString(2);

                resultList.add(new Group(groupId, groupName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static List<Student> getStudentsListFromResultSet(ResultSet resultSet) {
        List<Student> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int studentId = resultSet.getInt(1);
                String studentName = resultSet.getString(2);
                int groupId = resultSet.getInt(3);
                String groupName = resultSet.getString(4);

                resultList.add(new Student(studentId, studentName, new Group(groupId, groupName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static List<Subject> getSubjectsListFromResultSet(ResultSet resultSet) {
        List<Subject> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int subjectId = resultSet.getInt(1);
                String subjectName = resultSet.getString(2);
                String subjectDescription = resultSet.getString(3);

                resultList.add(new Subject(subjectId, subjectName, subjectDescription));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static List<Teacher> getTeachersAsListFromResultSet(ResultSet resultSet) {
        List<Teacher> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int teacherId = resultSet.getInt(1);
                String teacherName = resultSet.getString(2);
                int teacherExperience = resultSet.getInt(3);
                int subjectId = resultSet.getInt(4);
                String subjectName = resultSet.getString(5);
                String subjectDescription = resultSet.getString(6);

                resultList.add(new Teacher(teacherId, teacherName, teacherExperience, new Subject(subjectId, subjectName, subjectDescription)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }




}
