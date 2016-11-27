import dao.CommonDAO;
import dao.StudentDAO;
import model.Group;
import model.Lesson;
import model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static factory.LazySingletonEntityManagerfactory.getEntityMangerFactory;

/**
 * Created by Jack on 26.11.2016.
 */
public class TestFind {

    CommonDAO studentDAO = new StudentDAO(getEntityMangerFactory());


    public void init() {

        List<Group> groups = new ArrayList<>();
        Group group1 = new Group("group1");
        Group group2 = new Group("group1");
        Group group3 = new Group("group1");

        groups.add(group1);
        groups.add(group2);
        groups.add(group3);

        groups.stream().forEach(el -> studentDAO.addNewEntity(el));

        List<Lesson> lessons = new ArrayList<>();

        Lesson lesson1 = new Lesson("Math");
        Lesson lesson2 = new Lesson("Java");
        Lesson lesson3 = new Lesson("Web");

        lessons.add(lesson1);
        lessons.add(lesson2);
        lessons.add(lesson3);

        lessons.stream().forEach(el -> studentDAO.addNewEntity(el));

    }


    @Test
    public void testCreate() {

        System.out.println(studentDAO.create(new Student("Vasa", 2)));
    }

    @Test
    public void testFind() {

        System.out.println(studentDAO.findById(1, Student.class));
    }

    @Test
    public void testGetAllByEntityClass() {

        System.out.println(studentDAO.getAllByEntityClass(Student.class));
    }

    @Test
    public void testGetAllByParam() {

        System.out.println(studentDAO.getAllByEntityClassAndParameter(Student.class, "group_id", 2));
    }

}
