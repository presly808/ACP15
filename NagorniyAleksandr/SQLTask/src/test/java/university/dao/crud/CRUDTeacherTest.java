package university.dao.crud;

import org.h2.tools.RunScript;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.exceptions.AppDBException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;
import university.models.Teacher;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class CRUDTeacherTest {

    private static final DBConnector dbConnector;
    private static final QueryCreator queryCreator;
    public static final String CREATE_TEST_DB_SCRIPT = "/H2StructureScript.sql";
    public static final String DROP_TEST_DB_SCRIPT = "/H2DropDBScript.sql";

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

    @Test
    public void CRUDTeacher() throws Exception {

        int testTeacherId = -1;
        String testTeacherName = "Teacher " + System.currentTimeMillis();
        int testTeacherExperience = 10;


        Teacher testTeacher = new Teacher(testTeacherId, testTeacherName, testTeacherExperience);

        //test CREATE teacher
        assertTrue(queryCreator.addTeacher(testTeacher));

        //test auto-generation id
        assertTrue(testTeacher.getId() != testTeacherId);

        //test READ teacher
        Teacher addedTeacher = queryCreator.getTeacher(testTeacher);

        assertEquals(testTeacher.getId(), addedTeacher.getId());
        assertEquals(testTeacher.getName(), addedTeacher.getName());
        assertEquals(testTeacher.getExperience(), addedTeacher.getExperience());
        assertEquals(testTeacher, addedTeacher);

        //test error when read invalid teacher(id)
        int invalidId = -1;
        Teacher teacherNotFromDB = new Teacher(invalidId, testTeacherName, testTeacherExperience);

        try {
            queryCreator.getTeacher(teacherNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test UPDATE teacher
        String newTestTeacherName = "Teacher " + System.currentTimeMillis();
        testTeacher.setName(newTestTeacherName);

        assertTrue(queryCreator.editTeacher(testTeacher));

        Teacher updatedTeacher = queryCreator.getTeacher(testTeacher);

        assertEquals(newTestTeacherName, updatedTeacher.getName());
        assertEquals(testTeacher.getId(), updatedTeacher.getId());
        assertEquals(testTeacher.getExperience(), updatedTeacher.getExperience());

        //test error when update
        try {
            queryCreator.editTeacher(teacherNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test DELETE teacher
        assertNotNull(queryCreator.getTeacher(testTeacher));

        assertTrue(queryCreator.deleteTeacher(testTeacher));

        //try find deleted teacher
        try {
            queryCreator.getTeacher(testTeacher);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //try deleted teacher not from DB
        try {
            queryCreator.deleteTeacher(teacherNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }
}
