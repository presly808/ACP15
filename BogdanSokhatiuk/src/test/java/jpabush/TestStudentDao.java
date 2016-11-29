package jpabush;

import jpabush.dao.GeneralDao;
import jpabush.dao.StudentDao;
import jpabush.model.Group;
import jpabush.model.Student;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by lost on 26.11.2016.
 */
public class TestStudentDao extends DaoTextureTest {
    private StudentDao dao;
    private Student student;


    @Before
    public void init() {
        student = new Student("Ivan", new Group("APC15", 322));
        dao = new StudentDao(manager, Student.class);
    }

    @Test
    public void TestInsertStudent() {
        Assert.assertEquals(student, dao.create(student));
    }

    @Test
    public void TestGetAll() {
        dao.create(student);
        MatcherAssert.assertThat(dao.getAll().size(), Matchers.equalTo(4));

    }
    @Test
    public void TestGetAllByGroup() {
        MatcherAssert.assertThat(dao.getAllbygroup(new Group("APC15",0)).size(), Matchers.equalTo(3));

    }

    @Test
    public void TestUpdate() {
        student = dao.create(student);
        student.setGroup(new Group("ACP15",0));
        student=dao.update(student);
        MatcherAssert.assertThat(student.getGroup().getId(), Matchers.equalTo(0));

    }


    @After
    public void setDown() {
        dao.delete(student, student.getId());
    }

}
