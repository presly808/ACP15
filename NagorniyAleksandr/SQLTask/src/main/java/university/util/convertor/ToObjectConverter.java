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

            Group studentsGroup = new Group();
            studentsGroup.setId(groupId);
            studentsGroup.setName(groupName);

            Student student = new Student();
            student.setId(studentId);
            student.setName(studentName);
            student.setGroup(studentsGroup);

            return student;
        } else {
            return null;
        }
    }

    public static Group getOneGroupFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int groupId = resultSet.getInt("groupId");
            String groupName = resultSet.getString("groupName");

            Group group = new Group();
            group.setId(groupId);
            group.setName(groupName);


            return group;
        } else {
            return null;
        }
    }

    public static Teacher getOneTeacherFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            int teacherId = resultSet.getInt("teacherId");
            String teacherName = resultSet.getString("teacherName");
            int teacherExperience = resultSet.getInt("teacherExperience");

            Teacher teacher = new Teacher();
            teacher.setId(teacherId);
            teacher.setName(teacherName);
            teacher.setExperience(teacherExperience);

            return teacher;
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

            SubjectCategory subjectCategory = new SubjectCategory();
            subjectCategory.setId(categoryId);
            subjectCategory.setTitle(categoryTitle);

            Subject subject = new Subject();
            subject.setId(subjectId);
            subject.setName(subjectName);
            subject.setCategory(subjectCategory);
            subject.setDescription(subjectDescription);

            return subject;
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


            Group studentsGroup = new Group();
            studentsGroup.setId(groupId);
            studentsGroup.setName(groupName);

            Student student = new Student();
            student.setId(studentId);
            student.setName(studentName);
            student.setGroup(studentsGroup);

            result.add(student);
        }

        return result;
    }

    public static List<Subject> getSubjectsAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Subject> result = new ArrayList<>();

        while (resultSet.next()) {

            int subjectId = resultSet.getInt(1);
            String subjectName = resultSet.getString(2);
            int categoryId = resultSet.getInt(3);
            String categoryTitle = resultSet.getString(4);
            String subjectDescription = resultSet.getString(5);

            SubjectCategory subjectCategory = new SubjectCategory();
            subjectCategory.setId(categoryId);
            subjectCategory.setTitle(categoryTitle);

            Subject subject = new Subject();
            subject.setId(subjectId);
            subject.setName(subjectName);
            subject.setCategory(subjectCategory);
            subject.setDescription(subjectDescription);

            result.add(subject);
        }

        return result;
    }

    public static List<Group> getGroupsAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Group> result = new ArrayList<>();

        while (resultSet.next()) {

            int groupId = resultSet.getInt("groupId");
            String groupName = resultSet.getString("groupName");

            Group group = new Group();
            group.setId(groupId);
            group.setName(groupName);

            result.add(group);
        }

        return result;
    }

    public static List<Teacher> getTeachersAsListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Teacher> result = new ArrayList<>();

        while (resultSet.next()) {

            int teacherId = resultSet.getInt("teacherId");
            String teacherName = resultSet.getString("teacherName");
            int teacherExperience = resultSet.getInt("teacherExperience");

            Teacher teacher = new Teacher();
            teacher.setId(teacherId);
            teacher.setName(teacherName);
            teacher.setExperience(teacherExperience);

            result.add(teacher);
        }

        return result;
    }
}
