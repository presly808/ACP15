package university.dao.crud;

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

import static org.junit.Assert.*;

/**
 * Created by nagornyyalek on 17.11.2016.
 */
public class CRUDSubjectTest {
    private static final DBConnector dbConnector;
    private static final QueryCreator queryCreator;

    static {
        dbConnector = new DBConnectorMySQL();
        CRUDQuery crudQuery = new CRUDQueryImpl(dbConnector);
        queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);
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
        } catch (SubjectAlreadyExistsException e) {
            assertTrue(true);
        }

        //test READ subject
        Subject addedSubject = queryCreator.getSubject(testSubject);

        assertEquals(testSubject.getId(), addedSubject.getId());
        assertEquals(testSubject.getName(), addedSubject.getName());
        assertEquals(testSubject.getCategory().getId(), addedSubject.getCategory().getId());
        assertEquals(testSubject.getCategory().getTitle(), addedSubject.getCategory().getTitle());
        assertEquals(testSubject.getDescription(), addedSubject.getDescription());
        assertNotEquals(testSubject, addedSubject);

        //test error when read invalid
        int invalidSubjectId = -1;
        Subject subjectNotFromDB = new Subject(invalidSubjectId, testSubjectName,
                validSubjectCategory, testSubjectDescription);

        try {
            queryCreator.getSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (SubjectNotFoundException e) {
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
        } catch (SubjectNotFoundException e) {
            assertTrue(true);
        }

        //test error when update(subject from DB but set invalid subject category not from db)
        int invalidSubjectCategoryId = -1;
        SubjectCategory subjectCategoryNotFromDB = new SubjectCategory(invalidSubjectCategoryId, null);

        testSubject.setCategory(subjectCategoryNotFromDB);
        try {
            queryCreator.editSubject(testSubject);
            assertTrue(false);
        } catch (SubjectCategoryNotFoundException e) {
            assertTrue(true);
        }

        //test DELETE subject
        assertNotNull(queryCreator.getSubject(testSubject));

        assertTrue(queryCreator.deleteSubject(testSubject));

        //try find deleted subject
        try {
            queryCreator.getSubject(testSubject);
            assertTrue(false);
        } catch (SubjectNotFoundException e) {
            assertTrue(true);
        }

        //try deleted subject not from DB
        try {
            queryCreator.deleteSubject(subjectNotFromDB);
            assertTrue(false);
        } catch (SubjectNotFoundException e) {
            assertTrue(true);
        }
    }
}
