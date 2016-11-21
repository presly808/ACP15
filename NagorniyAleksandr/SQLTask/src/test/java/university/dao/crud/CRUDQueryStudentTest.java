package university.dao.crud;

import org.h2.tools.RunScript;
import org.junit.*;
import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.exceptions.AppDBException;
import university.exceptions.GroupNotFoundException;
import university.exceptions.StudentNotFoundException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;
import university.models.Group;
import university.models.Student;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CRUDQueryStudentTest {
    private static final DBConnector dbConnector;
    private static final QueryCreator queryCreator;
    public static final String CREATE_TEST_DB_SCRIPT = "/MySQLStructureAndDataScript.sql";
    public static final String DROP_TEST_DB_SCRIPT = "/MySQLDropTestDBScript.sql";

    private Group testStudentsGroup;
    private Group groupNotFromDB;

    private Student testStudent;
    private Student studentNotFromDB;

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

        String testStudentsName = "Student " + System.currentTimeMillis();
        int testStudentsId = -1;

        String testStudentsGroupName = "Gr" + System.currentTimeMillis();

        int testStudentsGroupId = -1;
        testStudentsGroup = new Group(testStudentsGroupId, testStudentsGroupName);
        queryCreator.addGroup(testStudentsGroup);

        testStudent = new Student(testStudentsId, testStudentsName, testStudentsGroup);
        queryCreator.addStudent(testStudent);

        int invalidGroupId = -1;
        groupNotFromDB = new Group(invalidGroupId, "Test");

        int invalidStudentId = -1;
        studentNotFromDB = new Student(invalidStudentId, testStudentsName, testStudentsGroup);

    }

    @After
    public void tearDown() throws Exception {
        queryCreator.deleteStudent(testStudent);
        studentNotFromDB = null;
        queryCreator.deleteGroup(testStudentsGroup);
        groupNotFromDB = null;
    }

    @Test
    public void addStudent() throws Exception {
        String testStudentsNameForAddTest = "Student " + System.currentTimeMillis();
        int testStudentsIdForAddTest = -1;
        Student testStudentForAddTest = new Student(testStudentsIdForAddTest, testStudentsNameForAddTest, testStudentsGroup);

        assertTrue(queryCreator.addStudent(testStudentForAddTest));
        queryCreator.getStudent(testStudentForAddTest);

        //test auto-generation id
        assertThat(testStudentForAddTest.getId(), not(equalTo(testStudentsIdForAddTest)));

        queryCreator.deleteStudent(testStudentForAddTest);
    }

    @Test
    public void addStudentNegative() throws Exception {
        int testStudentsId = -1;
        String testStudentsName = "Name";
        Student studentWithInvalidGroup = new Student(testStudentsId, testStudentsName, groupNotFromDB);

        try {
            queryCreator.addStudent(studentWithInvalidGroup);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editStudent() throws Exception {
        String newTestStudentName = "Student " + System.currentTimeMillis();
        testStudent.setName(newTestStudentName);

        assertTrue(queryCreator.editStudent(testStudent));

        Student updatedStudent = queryCreator.getStudent(testStudent);

        assertThat(newTestStudentName, equalTo(updatedStudent.getName()));
        assertThat(testStudent.getId(), equalTo(updatedStudent.getId()));
        assertThat(testStudent.getGroup().getId(), equalTo(updatedStudent.getGroup().getId()));
        assertThat(testStudent.getGroup().getName(), equalTo(updatedStudent.getGroup().getName()));
    }

    @Test
    public void editStudentNegativeInvalidNewData() throws Exception {
        testStudent.setGroup(groupNotFromDB);
        try {
            queryCreator.editStudent(testStudent);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editStudentNegativeStudentNotFromDB() throws Exception {
        try {
            queryCreator.editStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteStudent() throws Exception {
        assertNotNull(queryCreator.getStudent(testStudent));
        assertTrue(queryCreator.deleteStudent(testStudent));

        try {
            queryCreator.getStudent(testStudent);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        queryCreator.addStudent(testStudent);
    }

    @Test
    public void deleteStudentNegative() throws Exception {
        try {
            queryCreator.deleteStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getStudent() throws Exception {
        Student addedStudent = queryCreator.getStudent(testStudent);

        assertThat(testStudent.getId(), equalTo(addedStudent.getId()));
        assertThat(testStudent.getName(), equalTo(addedStudent.getName()));
        assertThat(testStudent, equalTo(addedStudent));
    }

    @Test
    public void getStudentNegative() throws Exception {
        try {
            queryCreator.getStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

}