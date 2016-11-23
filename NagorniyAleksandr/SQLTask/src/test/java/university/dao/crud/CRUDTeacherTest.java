package university.dao.crud;

import org.junit.Test;
import university.container.Factory;
import university.dao.QueryCreator;
import university.exceptions.AppDBException;
import university.models.Teacher;

import static org.junit.Assert.*;

public class CRUDTeacherTest extends PrepareTestDataBase {

    private QueryCreator queryCreator = Factory.getQueryCreator();

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
