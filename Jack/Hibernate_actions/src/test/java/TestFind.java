import dao.StudentDAO;
import model.Student;
import org.junit.Test;

import static dao.LazySingletonEntityManagerfactory.getEntityMangerFactory;

/**
 * Created by Jack on 26.11.2016.
 */
public class TestFind {

    StudentDAO studentDAO = new StudentDAO(getEntityMangerFactory());


    @Test
    public void testCreate() {

        System.out.println(studentDAO.create(new Student()));
    }

    @Test
    public void testFind() {

        System.out.println(studentDAO.findById(1, Student.class));
    }

}
