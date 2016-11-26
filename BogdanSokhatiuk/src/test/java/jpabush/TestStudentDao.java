package jpabush;

import jpabush.dao.GeneralDao;
import jpabush.model.Group;
import jpabush.model.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lost on 26.11.2016.
 */
public class TestStudentDao extends DaoTexture {
    private GeneralDao<Student> dao;
    private Student student;

    @Before
    public void init() {
        student = new Student("Ivan", new Group("APC15", 5));
        dao = new GeneralDao<>(manager, Student.class);
    }

    @Test
    public void TestInsertStudent() {

        Assert.assertEquals(student,dao.create(student));
    }


    @After
    public void tearDown() {
        dao = null;
        manager.close();

    }
}
