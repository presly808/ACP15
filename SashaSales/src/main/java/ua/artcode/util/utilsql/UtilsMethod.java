
package ua.artcode.util.utilsql;

import ua.artcode.model.modelsql.Group;
import ua.artcode.model.modelsql.Student;

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

        TypedQuery<ua.artcode.model.modeljpa.Group> query = entityManager.createQuery("SELECT g FROM Group g WHERE g.name = :group_name", ua.artcode.model.modeljpa.Group.class);
        query.setParameter("group_name", group_name);
        ua.artcode.model.modeljpa.Group group = query.getSingleResult();
        return group.getId();
    }

    public static int getIdOfStudent(String student_name, EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();

        TypedQuery<ua.artcode.model.modeljpa.Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :student_name", ua.artcode.model.modeljpa.Student.class);
        query.setParameter("student_name", student_name);
        ua.artcode.model.modeljpa.Student student = query.getSingleResult();
        return student.getId();
    }

    public static void utilResultSet(ResultSet resultSet, List<Student> students) throws SQLException {

        while (resultSet.next()) {
            int id_student = resultSet.getInt("id");
            String student_name = resultSet.getString("student_name");
            int id_group = resultSet.getInt("group_id");
            String group_name = resultSet.getString("group_name");
            Group group = new Group(id_group, group_name);
            Student student = new Student(id_student, student_name, group);
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
