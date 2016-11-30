package university.dao.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import university.container.AppEntityManagerFactory;
import university.container.Factory;
import university.dao.QueryCreator;
import university.exceptions.AppDBException;
import university.models.Subject;
import university.models.SubjectCategory;

import javax.persistence.EntityManager;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by nagornyyalek on 29.11.2016.
 */
public class CRUDQuerySubjectCategoryTest extends PrepareTestDataBase {
    private SubjectCategory validSubjectCategory;
    private SubjectCategory subjectCategoryNotFromDB;

    @Before
    public void setUp() throws Exception {
        String testSubjectCategoryTitle = "SC" + System.currentTimeMillis();

        validSubjectCategory = new SubjectCategory();
        validSubjectCategory.setTitle(testSubjectCategoryTitle);
        queryCreator.addSubjectCategory(validSubjectCategory);

        int invalidId = -1;
        subjectCategoryNotFromDB = new SubjectCategory();
        subjectCategoryNotFromDB.setId(invalidId);
        subjectCategoryNotFromDB.setTitle("Invalid SC");
    }

    @After
    public void tearDown() throws Exception {

        try {
            queryCreator.deleteSubjectCategory(validSubjectCategory);
        } catch (AppDBException e) {}

        validSubjectCategory = null;
        subjectCategoryNotFromDB = null;
    }

    @Test
    public void addSubjectCategory() throws Exception {
        String testSubjectCategoryNameForAddTest = "SC" + System.currentTimeMillis();


        SubjectCategory testSubjectCategoryForAddTest = new SubjectCategory();
        testSubjectCategoryForAddTest.setTitle(testSubjectCategoryNameForAddTest);

        assertTrue(queryCreator.addSubjectCategory(testSubjectCategoryForAddTest));

        //test auto-generation id
        int defaultId = 0;
        assertThat(testSubjectCategoryForAddTest.getId(), not(equalTo(defaultId)));

        queryCreator.deleteSubjectCategory(testSubjectCategoryForAddTest);

    }

    @Test
    public void addSubjectCategoryNegativeInvalidCategory() throws Exception {
        String testSubjectCategoryNameForAddTest = null;

        SubjectCategory testSubjectCategoryWithInvalidCategory = new SubjectCategory();
        testSubjectCategoryWithInvalidCategory.setTitle(testSubjectCategoryNameForAddTest);

        try {
            queryCreator.addSubjectCategory(testSubjectCategoryWithInvalidCategory);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addSubjectCategoryNegativeDuplicate() throws Exception {
        try {
            queryCreator.addSubjectCategory(validSubjectCategory);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editSubjectCategory() throws Exception {
        String newTestSubjectCategoryName = "SC" + System.currentTimeMillis();
        validSubjectCategory.setTitle(newTestSubjectCategoryName);

        assertTrue(queryCreator.editSubjectCategory(validSubjectCategory));

        SubjectCategory updatedSubjectCategory = queryCreator.getSubjectCategory(validSubjectCategory);

        assertThat(newTestSubjectCategoryName, equalTo(updatedSubjectCategory.getTitle()));
        assertThat(validSubjectCategory.getId(), equalTo(updatedSubjectCategory.getId()));
    }

    @Test
    public void editSubjectNegativeSubjectNotFromDB() throws Exception {
        try {
            queryCreator.editSubjectCategory(subjectCategoryNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteSubjectCategory() throws Exception {
        assertNotNull(queryCreator.getSubjectCategory(validSubjectCategory));

        assertTrue(queryCreator.deleteSubjectCategory(validSubjectCategory));

        try {
            queryCreator.getSubjectCategory(validSubjectCategory);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteSubjectCategoryNegative() throws Exception {
        try {
            queryCreator.deleteSubjectCategory(subjectCategoryNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getSubjectCategory() throws Exception {
        SubjectCategory addedSubjectCategory = queryCreator.getSubjectCategory(validSubjectCategory);

        assertThat(validSubjectCategory.getId(), equalTo(addedSubjectCategory.getId()));
        assertThat(validSubjectCategory.getTitle(), equalTo(addedSubjectCategory.getTitle()));
        assertThat(validSubjectCategory, equalTo(addedSubjectCategory));
    }

    @Test
    public void getSubjectCategoryNegative() throws Exception {
        try {
            queryCreator.getSubjectCategory(subjectCategoryNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

}
