import dao.CommonDAO;
import dao.StudentDAO;
import model.Student;
import org.junit.Test;

import static factory.LazySingletonEntityManagerfactory.getEntityMangerFactory;

/**
 * Created by Jack on 26.11.2016.
 */
public class TestFind {

    CommonDAO studentDAO = new StudentDAO(getEntityMangerFactory());


    @Test
    public void testCreate() {

        System.out.println(studentDAO.create(new Student("Vasa", 2)));
    }

    @Test
    public void testFind() {

        System.out.println(studentDAO.findById(1, Student.class));
    }

    @Test
    public void testGetAll() {

        System.out.println(studentDAO.getAllByEntityClass(Student.class));
    }

    @Test
    public void testGetAllByParam() {

        System.out.println(studentDAO.getAllByEntityClassAndParameter(Student.class, "group_id", 2));
    }

}
