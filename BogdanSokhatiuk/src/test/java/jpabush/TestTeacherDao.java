package jpabush;

import jpabush.dao.TeacherDao;
import jpabush.model.Group;
import jpabush.model.Subject;
import jpabush.model.Teacher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lost on 30.11.2016.
 */
public class TestTeacherDao extends DaoTextureTest {
    private TeacherDao dao;
    private Teacher teacher;


    @Before
    public void init() {
        teacher = new Teacher("Ivan", 5, new Subject(68, "Math", "Matimatics"));
        dao = new TeacherDao(manager);
    }

    @Test
    public void TestInsertStudent() {
        Assert.assertEquals(teacher, dao.create(teacher));
    }

    @Test
    public void TestGetAll() {
        MatcherAssert.assertThat(dao.getAll().size(), Matchers.equalTo(40));

    }

    @Test
    public void TestGetByGroup() {
        MatcherAssert.assertThat(dao.getAllbySubject(new Subject(68, "Math", "Matimatics")).size(), Matchers.equalTo(2));

    }


    @After
    public void setDown() {
        dao.delete(teacher, teacher.getId());
    }
}
