package jdbcmySql;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lost on 12.11.2016.
 */
public class testJDBCtask {
    private JdbcTask jdbcTask;

    @Before
    public void setUp() {
        jdbcTask = new JdbcTask();
    }

    @Test
    public void TestTask1() {
        List<Student> list = jdbcTask.getAll(Student.class);
        Assert.assertEquals(list.size(), 13);
    }

    @Test
    public void TestTask2() {
        Student student = new Student(150,"Test",1);
        List<Student> list = jdbcTask.getAll(Student.class);
        jdbcTask.insert(student);
        List<Student> list2 = jdbcTask.getAll(Student.class);
        Assert.assertEquals(list2.size(), list.size()+1);
    }
    @Test
    public void TestTask3() {
        List<Student> list = jdbcTask.getAllstudentsByGroup(1);
        Assert.assertEquals(5, list.size());
    }


    @After
    public void tearDown() {
        JdbcBush jdbcBush = new JdbcBushIpml();
        try {
            jdbcBush.sqlDeleteUpdateInsert("Delete from students where name='Test'");
            jdbcBush.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
