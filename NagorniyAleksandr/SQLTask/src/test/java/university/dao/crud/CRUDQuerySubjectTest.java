package university.dao.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import university.container.AppEntityManagerFactory;
import university.exceptions.AppDBException;
import university.models.Subject;
import university.models.SubjectCategory;

import javax.persistence.EntityManager;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CRUDQuerySubjectTest extends PrepareTestDataBase {

    private SubjectCategory validSubjectCategory;
    private Subject testSubject;

    private SubjectCategory subjectCategoryNotFromDB;
    private Subject subjectNotFromDB;

    @Before
    public void setUp() throws Exception {
        String testSubjectName = "Sub" + System.currentTimeMillis();
        String testSubjectDescription = "TestDescription";

        EntityManager entityManager = AppEntityManagerFactory.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.createNativeQuery("INSERT INTO SUBJECT_CATEGORYS(ID, TITLE) VALUES (1, 'Exact'),(2, 'Humanities')");
        } finally {
            entityManager.close();
        }

        //String testSubjectCategoryName = "SC" + System.currentTimeMillis();
        validSubjectCategory = new SubjectCategory("Exact");
        validSubjectCategory.setId(278);

        testSubject = new Subject();
        testSubject.setName(testSubjectName);
        testSubject.setCategory(validSubjectCategory);
        testSubject.setDescription(testSubjectDescription);
        queryCreator.addSubject(testSubject);


        subjectCategoryNotFromDB = new SubjectCategory("Invalid Name");

        String testSubjectNotFromDBName = "Sub" + System.currentTimeMillis();
        subjectNotFromDB = new Subject();
        subjectNotFromDB.setName(testSubjectNotFromDBName);
        subjectNotFromDB.setCategory(validSubjectCategory);
        subjectNotFromDB.setDescription(testSubjectDescription);
    }

    @After
    public void tearDown() throws Exception {

        try {
            queryCreator.deleteSubject(testSubject);
        } catch (AppDBException e) {}

        subjectNotFromDB = null;
        validSubjectCategory = null;
        subjectCategoryNotFromDB = null;
    }

    @Test
    public void addSubject() throws Exception {
        String testSubjectNameForAddTest = "Sub" + System.currentTimeMillis();
        String testSubjectDescriptionForAddTest = "TestDescription";

        Subject testSubjectForAddTest = new Subject();
        testSubjectForAddTest.setName(testSubjectNameForAddTest);
        testSubjectForAddTest.setCategory(validSubjectCategory);
        testSubjectForAddTest.setDescription(testSubjectDescriptionForAddTest);

        assertTrue(queryCreator.addSubject(testSubjectForAddTest));

        //test auto-generation id
        int defaultId = 0;
        assertThat(testSubject.getId(), not(equalTo(defaultId)));

        queryCreator.deleteSubject(testSubjectForAddTest);

    }

    @Test
    public void addSubjectNegativeInvalidCategory() throws Exception {
        String testSubjectNameForAddTest = "Sub" + System.currentTimeMillis();
        String testSubjectDescriptionForAddTest = "TestDescription";

        Subject testSubjectWithInvalidCategory = new Subject();
        testSubjectWithInvalidCategory.setName(testSubjectNameForAddTest);
        testSubjectWithInvalidCategory.setCategory(subjectCategoryNotFromDB);
        testSubjectWithInvalidCategory.setDescription(testSubjectDescriptionForAddTest);

        try {
            queryCreator.addSubject(testSubjectWithInvalidCategory);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addSubjectNegativeDuplicate() throws Exception {
        try {
            queryCreator.addSubject(testSubject);
            assertTrue(false);
        } catch (AppDBException e) {
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
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editSubjectNegativeInvalidCategory() throws Exception {

        testSubject.setCategory(subjectCategoryNotFromDB);

        try {
            queryCreator.editSubject(testSubject);
            assertTrue(false);
        } catch (AppDBException e) {
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
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteSubjectNegative() throws Exception {
        try {
            queryCreator.deleteSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
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
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

}