
package ua.artcode.util;

import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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

/*     public static <T> T getEntityByName(T t, String t_name, EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();
        Query query1 = entityManager.createQuery("SELECT t FROM T t WHERE t.name = :t_name");
        query1.setParameter("t_name", t_name);
        t = (T) query1.getSingleResult();
         return t;
    }*/

     public static Group getGroupByName(String group_name, EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();
        TypedQuery<Group> query1 = entityManager.createQuery("SELECT g FROM Group g WHERE g.name = :group_name", Group.class);
        query1.setParameter("group_name", group_name);
        Group group = (Group) query1.getSingleResult();
         return group;
    }

    public static int getIdOfStudent(String student_name, EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :student_name", Student.class);
        query.setParameter("student_name", student_name);
        Student student = query.getSingleResult();
        return student.getId();
    }

    public static int getIdOfSubject(String subject_name, EntityManagerFactory managerFactory) {

        EntityManager entityManager = managerFactory.createEntityManager();

        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :subject_name", Subject.class);
        query.setParameter("subject_name", subject_name);
        Subject subject = query.getSingleResult();
        return subject.getId();
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
