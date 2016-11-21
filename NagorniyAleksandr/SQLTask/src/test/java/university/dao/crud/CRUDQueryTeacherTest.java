package university.dao.crud;

import org.h2.tools.RunScript;
import org.junit.*;
import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.exceptions.AppDBException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;
import university.models.Teacher;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CRUDQueryTeacherTest {

    private static final DBConnector dbConnector;
    private static final QueryCreator queryCreator;
    public static final String CREATE_TEST_DB_SCRIPT = "/H2StructureScript.sql";
    public static final String DROP_TEST_DB_SCRIPT = "/H2DropDBScript.sql";

    Teacher testTeacher;
    Teacher teacherNotFromDB;

    static {
        dbConnector = new DBConnectorImpl();
        CRUDQuery crudQuery = new CRUDQueryImpl(dbConnector);
        queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);
    }

    @BeforeClass
    public static void initDB() throws Exception {
        InputStream is = CRUDGroupAndStudentTest.class.
                getResourceAsStream(CREATE_TEST_DB_SCRIPT);
        RunScript.execute(dbConnector.getConnection(), new InputStreamReader(is));
    }

    @AfterClass
    public static void dropDB() throws Exception {
        InputStream is = CRUDGroupAndStudentTest.class.
                getResourceAsStream(DROP_TEST_DB_SCRIPT);
        RunScript.execute(dbConnector.getConnection(), new InputStreamReader(is));
    }

    @Before
    public void setUp() throws Exception {
        int testTeacherId = -1;
        String testTeacherName = "Teacher " + System.currentTimeMillis();
        int testTeacherExperience = 10;

        testTeacher = new Teacher(testTeacherId, testTeacherName, testTeacherExperience);
        queryCreator.addTeacher(testTeacher);

        int invalidId = -1;
        teacherNotFromDB = new Teacher(invalidId, testTeacherName, testTeacherExperience);
    }

    @After
    public void tearDown() throws Exception {
        queryCreator.deleteTeacher(testTeacher);
        teacherNotFromDB = null;
    }

    @Test
    public void addTeacher() throws Exception {
        int testTeacherIdForAddTest = -1;
        String testTeacherNameForAddTest = "Teacher " + System.currentTimeMillis();
        int testTeacherExperienceForAddTest = 10;

        Teacher testTeacherForAddTest = new Teacher(testTeacherIdForAddTest,
                testTeacherNameForAddTest, testTeacherExperienceForAddTest);

        assertTrue(queryCreator.addTeacher(testTeacherForAddTest));

        //test auto-generation id
        assertThat(testTeacherForAddTest.getId(), not(equalTo(testTeacherIdForAddTest)));

        //test READ teacher
        Teacher addedTeacher = queryCreator.getTeacher(testTeacherForAddTest);

        queryCreator.deleteTeacher(testTeacherForAddTest);
    }

    @Test
    public void editTeacher() throws Exception {
        String newTestTeacherName = "Teacher " + System.currentTimeMillis();
        testTeacher.setName(newTestTeacherName);

        assertTrue(queryCreator.editTeacher(testTeacher));

        Teacher updatedTeacher = queryCreator.getTeacher(testTeacher);

        assertThat(newTestTeacherName, equalTo(updatedTeacher.getName()));
        assertThat(testTeacher.getId(), equalTo(updatedTeacher.getId()));
        assertThat(testTeacher.getExperience(), equalTo(updatedTeacher.getExperience()));
    }

    @Test
    public void editTeacherNegative() throws Exception {
        try {
            queryCreator.editTeacher(teacherNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteTeacher() throws Exception {
        assertNotNull(queryCreator.getTeacher(testTeacher));

        assertTrue(queryCreator.deleteTeacher(testTeacher));

        //try find deleted teacher
        try {
            queryCreator.getTeacher(testTeacher);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        queryCreator.addTeacher(testTeacher);
    }

    @Test
    public void deleteTeacherNegative() throws Exception {
        try {
            queryCreator.deleteTeacher(teacherNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getTeacher() throws Exception {
        Teacher addedTeacher = queryCreator.getTeacher(testTeacher);

        assertThat(testTeacher.getId(), equalTo(addedTeacher.getId()));
        assertThat(testTeacher.getName(), equalTo(addedTeacher.getName()));
        assertThat(testTeacher.getExperience(), equalTo(addedTeacher.getExperience()));
        assertThat(testTeacher, equalTo(addedTeacher));
    }

    @Test
    public void getTeacherNegative() throws Exception {

        try {
            queryCreator.getTeacher(teacherNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }
}