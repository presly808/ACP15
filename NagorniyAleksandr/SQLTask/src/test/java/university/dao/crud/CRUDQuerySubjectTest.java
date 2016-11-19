package university.dao.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.exceptions.SubjectAlreadyExistsException;
import university.exceptions.SubjectCategoryNotFoundException;
import university.exceptions.SubjectNotFoundException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorMySQL;
import university.models.Subject;
import university.models.SubjectCategory;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;


public class CRUDQuerySubjectTest {

    private static final DBConnector dbConnector;
    private static final QueryCreator queryCreator;

    private SubjectCategory validSubjectCategory;
    private Subject testSubject;

    private SubjectCategory subjectCategoryNotFromDB;
    private Subject subjectNotFromDB;

    static {
        dbConnector = new DBConnectorMySQL();
        CRUDQuery crudQuery = new CRUDQueryImpl(dbConnector);
        queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);
    }

    @Before
    public void setUp() throws Exception {
        String testSubjectName = "Sub" + System.currentTimeMillis();
        int testSubjectId = -1;
        String testSubjectDescription = "TestDescription";

        validSubjectCategory = new SubjectCategory(1, "Exact");

        testSubject = new Subject(testSubjectId, testSubjectName,
                validSubjectCategory, testSubjectDescription);
        queryCreator.addSubject(testSubject);


        int invalidSubjectCategoryId = -1;
        subjectCategoryNotFromDB = new SubjectCategory(invalidSubjectCategoryId, null);

        int invalidSubjectId = -1;
        subjectNotFromDB = new Subject(invalidSubjectId, testSubjectName,
                validSubjectCategory, testSubjectDescription);
    }

    @After
    public void tearDown() throws Exception {

        queryCreator.deleteSubject(testSubject);
        subjectNotFromDB = null;
        validSubjectCategory = null;
        subjectCategoryNotFromDB = null;
    }

    @Test
    public void addSubject() throws Exception {
        String testSubjectNameForAddTest = "Sub" + System.currentTimeMillis();
        int testSubjectIdForAddTest = -1;
        String testSubjectDescriptionForAddTest = "TestDescription";

        validSubjectCategory = new SubjectCategory(1, "Exact");

        Subject testSubjectForAddTest = new Subject(testSubjectIdForAddTest, testSubjectNameForAddTest,
                validSubjectCategory, testSubjectDescriptionForAddTest);

        assertTrue(queryCreator.addSubject(testSubjectForAddTest));

        //test auto-generation id
        assertThat(testSubject.getId(), not(equalTo(testSubjectIdForAddTest)));

        queryCreator.deleteSubject(testSubjectForAddTest);

    }

    @Test
    public void addSubjectNegativeInvalidCategory() throws Exception {
        String testSubjectNameForAddTest = "Sub" + System.currentTimeMillis();
        int testSubjectIdForAddTest = -1;
        String testSubjectDescriptionForAddTest = "TestDescription";

        Subject testSubjectWithInvalidCategory = new Subject(testSubjectIdForAddTest, testSubjectNameForAddTest,
                subjectCategoryNotFromDB, testSubjectDescriptionForAddTest);

        try {
            queryCreator.addSubject(testSubjectWithInvalidCategory);
            assertTrue(false);
        } catch (SubjectCategoryNotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addSubjectNegativeDuplicate() throws Exception {
        try {
            queryCreator.addSubject(testSubject);
            assertTrue(false);
        } catch (SubjectAlreadyExistsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editSubject() throws Exception {
        String newTestSubjectName = "Sub" + System.currentTimeMillis();
        testSubject.setName(newTestSubjectName);

        assertTrue(queryCreator.editSubject(testSubject));

        Subject updatedSubject = queryCreator.getSubject(testSubject);

        assertThat(newTestSubjectName, equalTo(updatedSubject.getName()));
        assertThat(testSubject.getId(), equalTo(updatedSubject.getId()));
        assertThat(testSubject.getDescription(), equalTo(updatedSubject.getDescription()));
        assertThat(testSubject.getCategory().getId(), equalTo(updatedSubject.getCategory().getId()));
        assertThat(testSubject.getCategory().getTitle(), equalTo(updatedSubject.getCategory().getTitle()));

    }

    @Test
    public void editSubjectNegativeSubjectNotFromDB() throws Exception {
        try {
            queryCreator.editSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (SubjectNotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editSubjectNegativeInvalidCategory() throws Exception {

        testSubject.setCategory(subjectCategoryNotFromDB);

        try {
            queryCreator.editSubject(testSubject);
            assertTrue(false);
        } catch (SubjectCategoryNotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteSubject() throws Exception {
        assertNotNull(queryCreator.getSubject(testSubject));

        assertTrue(queryCreator.deleteSubject(testSubject));

        try {
            queryCreator.getSubject(testSubject);
            assertTrue(false);
        } catch (SubjectNotFoundException e) {
            assertTrue(true);
        }

        queryCreator.addSubject(testSubject);
    }

    @Test
    public void deleteSubjectNegative() throws Exception {
        try {
            queryCreator.deleteSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (SubjectNotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getSubject() throws Exception {
        Subject addedSubject = queryCreator.getSubject(testSubject);

        assertThat(testSubject.getId(), equalTo(addedSubject.getId()));
        assertThat(testSubject.getName(), equalTo(addedSubject.getName()));
        assertThat(testSubject.getCategory().getId(), equalTo(addedSubject.getCategory().getId()));
        assertThat(testSubject.getCategory().getTitle(), equalTo(addedSubject.getCategory().getTitle()));
        assertThat(testSubject.getDescription(), equalTo(addedSubject.getDescription()));
        assertThat(testSubject, equalTo(addedSubject));
    }

    @Test
    public void getSubjectNegative() throws Exception {
        try {
            queryCreator.getSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (SubjectNotFoundException e) {
            assertTrue(true);
        }
    }

}