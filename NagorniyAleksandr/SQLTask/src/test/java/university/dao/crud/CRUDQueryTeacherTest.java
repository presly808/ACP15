package university.dao.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import university.exceptions.AppDBException;
import university.models.Teacher;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CRUDQueryTeacherTest extends PrepareTestDataBase {

    Teacher testTeacher;
    Teacher teacherNotFromDB;

    @Before
    public void setUp() throws Exception {

        String testTeacherName = "Teacher " + System.currentTimeMillis();
        int testTeacherExperience = 10;

        testTeacher = new Teacher();
        testTeacher.setName(testTeacherName);
        testTeacher.setExperience(testTeacherExperience);
        queryCreator.addTeacher(testTeacher);

        String testTeacherNotFromDBName = "Teacher " + System.currentTimeMillis();
        teacherNotFromDB = new Teacher();
        teacherNotFromDB.setName(testTeacherNotFromDBName);
        teacherNotFromDB.setExperience(testTeacherExperience);
    }

    @After
    public void tearDown() throws Exception {
        try {
            queryCreator.deleteTeacher(testTeacher);
        } catch (AppDBException e) {}

        teacherNotFromDB = null;
    }

    @Test
    public void addTeacher() throws Exception {
        int testTeacherIdForAddTest = -1;
        String testTeacherNameForAddTest = "Teacher " + System.currentTimeMillis();
        int testTeacherExperienceForAddTest = 10;

        Teacher testTeacherForAddTest = new Teacher();
        testTeacherForAddTest.setName(testTeacherNameForAddTest);
        testTeacherForAddTest.setExperience(testTeacherExperienceForAddTest);

        assertTrue(queryCreator.addTeacher(testTeacherForAddTest));

        //test auto-generation id
        int defaultId = 0;
        assertThat(testTeacherForAddTest.getId(), not(equalTo(defaultId)));

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