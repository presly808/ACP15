package jdbcmySql;

import jdbcmySql.dbMySql.JdbcBush;
import jdbcmySql.dbMySql.JdbcBushIpml;
import jdbcmySql.dbMySql.JdbcTask;
import jdbcmySql.dbMySql.SqlConnection;
import jdbcmySql.model.Student;
import jdbcmySql.utils.PropertiesHolder;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.log4j.Logger;
import org.junit.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static jdbcmySql.model.SqlScripts.SQLTEST6;

/**
 * Created by lost on 12.11.2016.
 */
public class TestJDBCtask {
    private JdbcTask jdbcTask;
    private static final Logger LOG = Logger.getLogger(PropertiesHolder.class);

    @BeforeClass
    public static void setUp() throws Exception {
        Connection con = new SqlConnection().getConnection();
        ScriptRunner scriptRunner = new ScriptRunner(con);
        InputStream is = TestJDBCtask.class.getResourceAsStream("/sqlsripts.sql");
        scriptRunner.runScript(new InputStreamReader(is));
    }

    @Before
    public void beforeMethod() {
        jdbcTask = new JdbcTask();
    }

    @Test
    public void TestTask1() {
        List<Student> list = jdbcTask.getAll(Student.class);
        Assert.assertEquals(list.size(), 10);
    }

    @Test
    public void TestTask2() {
        Student student = new Student(150, "Test", 1);
        List<Student> list = jdbcTask.getAll(Student.class);
        jdbcTask.insert(student);
        List<Student> list2 = jdbcTask.getAll(Student.class);
        Assert.assertEquals(list2.size(), list.size() + 1);
    }

    @Test
    public void TestTask3() {
        List<Student> list = jdbcTask.getAllstudentsByGroup(1);
        Assert.assertEquals(4, list.size());
    }


    @After
    public void tearDown() {
        JdbcBush jdbcBush = new JdbcBushIpml();
        try {
            jdbcBush.sqlDeleteUpdateInsert(SQLTEST6);
            jdbcBush.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
