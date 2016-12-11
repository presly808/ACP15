package converter;

import model.Group;
import model.Student;
import model.Subject;
import model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Imant on 26.11.16.
 */
public class ResultSetToObjectConverter {

    public static Student convertResultSetToStudent(ResultSet resultSet) throws SQLException {

        Student student = new Student();
        if (resultSet.next()) {
            int student_id = resultSet.getInt(1);
            String studentName = resultSet.getString(2);
            int groupId = resultSet.getInt(3);
            String groupName = resultSet.getString(4);
            student.setId(student_id);
            student.setName(studentName);
            student.setGroup(new Group(groupId, groupName));
        }
        return student;
    }

    public static Group convertResultSetToGroup(ResultSet resultSet) throws SQLException {

        Group group = new Group();
        if (resultSet.next()) {
            int groupId = resultSet.getInt(1);
            String groupName = resultSet.getString(2);
            group.setId(groupId);
            group.setName(groupName);
        }
        return group;
    }

    public static Subject convertResultSetToSubject(ResultSet resultSet) throws SQLException {

        Subject subject = new Subject();
        if (resultSet.next()) {
            int subjectId = resultSet.getInt(1);
            String subjectName = resultSet.getString(2);
            String subjectDescription = resultSet.getString(3);

            subject.setId(subjectId);
            subject.setName(subjectName);
            subject.setDescription(subjectDescription);
        }
        return subject;
    }

    public static Teacher convertResultSetToTeacher(ResultSet resultSet) throws SQLException {

        Teacher teacher = new Teacher();
        if (resultSet.next()) {
            int teacherId = resultSet.getInt(1);
            String teacherName = resultSet.getString(2);
            int teacherExperience = resultSet.getInt(3);

            int subjectId = resultSet.getInt(4);
            String subjectName = resultSet.getString(5);
            String subjectDescription = resultSet.getString(6);

            Subject subject = new Subject(subjectId, subjectName, subjectDescription);

            teacher.setId(teacherId);
            teacher.setName(teacherName);
            teacher.setExperience(teacherExperience);
            teacher.setSubject(subject);
        }
        return teacher;
    }
}
