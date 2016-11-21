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
import university.models.Subject;
import university.models.SubjectCategory;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class CRUDSubjectTest {
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
    public void CRUDSubject() throws Exception {

        String testSubjectName = "Sub" + System.currentTimeMillis();
        int testSubjectId = -1;
        String testSubjectDescription = "TestDescription";

        SubjectCategory validSubjectCategory = new SubjectCategory(1, "Exact");

        Subject testSubject = new Subject(testSubjectId, testSubjectName, validSubjectCategory, testSubjectDescription);

        //test CREATE subject
        assertTrue(queryCreator.addSubject(testSubject));

        //test auto-generation id
        assertTrue(testSubject.getId() != testSubjectId);

        //test error when duplicate
        try {
            queryCreator.addSubject(testSubject);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test READ subject
        Subject addedSubject = queryCreator.getSubject(testSubject);

        assertEquals(testSubject.getId(), addedSubject.getId());
        assertEquals(testSubject.getName(), addedSubject.getName());
        assertEquals(testSubject.getCategory().getId(), addedSubject.getCategory().getId());
        assertEquals(testSubject.getCategory().getTitle(), addedSubject.getCategory().getTitle());
        assertEquals(testSubject.getDescription(), addedSubject.getDescription());
        assertEquals(testSubject, addedSubject);

        //test error when read invalid
        int invalidSubjectId = -1;
        Subject subjectNotFromDB = new Subject(invalidSubjectId, testSubjectName,
                validSubjectCategory, testSubjectDescription);

        try {
            queryCreator.getSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test UPDATE subject
        String newTestSubjectName = "Sub" + System.currentTimeMillis();
        testSubject.setName(newTestSubjectName);

        assertTrue(queryCreator.editSubject(testSubject));

        Subject updatedSubject = queryCreator.getSubject(testSubject);

        assertEquals(newTestSubjectName, updatedSubject.getName());
        assertEquals(testSubject.getId(), updatedSubject.getId());
        assertEquals(testSubject.getDescription(), updatedSubject.getDescription());
        assertEquals(testSubject.getCategory().getId(), updatedSubject.getCategory().getId());
        assertEquals(testSubject.getCategory().getTitle(), updatedSubject.getCategory().getTitle());

        //test error when update(subject not from DB)
        try {
            queryCreator.editSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test error when update(subject from DB but set invalid subject category not from db)
        int invalidSubjectCategoryId = -1;
        SubjectCategory subjectCategoryNotFromDB = new SubjectCategory(invalidSubjectCategoryId, null);

        testSubject.setCategory(subjectCategoryNotFromDB);
        try {
            queryCreator.editSubject(testSubject);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test DELETE subject
        assertNotNull(queryCreator.getSubject(testSubject));

        assertTrue(queryCreator.deleteSubject(testSubject));

        //try find deleted subject
        try {
            queryCreator.getSubject(testSubject);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //try deleted subject not from DB
        try {
            queryCreator.deleteSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }
}
