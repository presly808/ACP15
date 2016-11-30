
package ua.artcode.util;

import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;
import ua.artcode.model.modeljpa.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by work on 15.11.2016.
 */

public class UtilsMethod {

    public static int getIdOfGroup(String group_name, EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();

        TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g WHERE g.name = :group_name", Group.class);
        query.setParameter("group_name", group_name);
        Group group = query.getSingleResult();
        return group.getId();
    }

    public static int getIdOfStudent(String student_name, EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :student_name", Student.class);
        query.setParameter("student_name", student_name);
        ua.artcode.model.modeljpa.Student student = query.getSingleResult();
        return student.getId();
    }

    public static int getIdOfSubject(String subject_name, EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();

        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :subject_name", Subject.class);
        query.setParameter("subject_name", subject_name);
        Subject subject = query.getSingleResult();
        return subject.getId();
    }


    public static void utilResultSet(ResultSet resultSet, List<ua.artcode.model.modelsql.Student> students) throws SQLException {

        while (resultSet.next()) {
            int id_student = resultSet.getInt("id");
            String student_name = resultSet.getString("student_name");
            int id_group = resultSet.getInt("group_id");
            String group_name = resultSet.getString("group_name");
            ua.artcode.model.modelsql.Group group = new ua.artcode.model.modelsql.Group(id_group, group_name);
            ua.artcode.model.modelsql.Student student = new ua.artcode.model.modelsql.Student(id_student, student_name, group);
            students.add(student);
        }
    }

    public static final String PATH_FOR_PROPERTY_NAME = "src/main/resources/propertyName.txt";

    public static boolean write(String propertyName) {

        try( FileWriter fw = new FileWriter(PATH_FOR_PROPERTY_NAME)) {
            fw.write(propertyName);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static String read() {

        String str = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH_FOR_PROPERTY_NAME));
            str = br.readLine();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }

        return str;
    }



}
