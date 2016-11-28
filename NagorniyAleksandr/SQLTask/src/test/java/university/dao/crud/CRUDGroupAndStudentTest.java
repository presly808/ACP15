package university.dao.crud;

import org.junit.Test;
import university.container.Factory;
import university.dao.QueryCreator;
import university.exceptions.AppDBException;
import university.models.Group;
import university.models.Student;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CRUDGroupAndStudentTest {

    protected QueryCreator queryCreator = Factory.getQueryCreator();

    @Test
    public void CRUDGroupAndStudents() throws Exception {

        String testGroupName = "Gr" + System.currentTimeMillis();

        Group testGroup = new Group();
        testGroup.setName(testGroupName);

        int defaultId = testGroup.getId();

        //test CREATE group
        assertTrue(queryCreator.addGroup(testGroup));

        //test auto-generation id
        assertThat(testGroup.getId(), not(equalTo(defaultId)));

        //test error when duplicate
        try {
            queryCreator.addGroup(testGroup);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test READ group
        Group addedGroup = queryCreator.getGroup(testGroup);

        assertEquals(testGroup.getId(), addedGroup.getId());
        assertEquals(testGroup.getName(), addedGroup.getName());
        assertEquals(testGroup, addedGroup);

        //test error when read invalid
        int invalidId = -1;
        Group groupNotFromDB = new Group();
        groupNotFromDB.setId(invalidId);
        groupNotFromDB.setName("Test");

        try {
            queryCreator.getGroup(groupNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test UPDATE group
        String newTestGroupName = "Gr" + System.currentTimeMillis();
        testGroup.setName(newTestGroupName);

        assertTrue(queryCreator.editGroup(testGroup));

        Group updatedGroup = queryCreator.getGroup(testGroup);

        assertEquals(newTestGroupName, updatedGroup.getName());
        assertEquals(testGroup.getId(), updatedGroup.getId());

        //test error when update
        try {
            queryCreator.editGroup(groupNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test DELETE group
        assertNotNull(queryCreator.getGroup(testGroup));

        assertTrue(queryCreator.deleteGroup(testGroup));

        //try find deleted group
        try {
            queryCreator.getGroup(testGroup);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //try deleted group not from DB
        try {
            queryCreator.deleteGroup(groupNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }


        //START TESTING FOR STUDENT(contains group which must be in DB)

        String testStudentsName = "Student " + System.currentTimeMillis();

        String testStudentsGroupName = "Gr" + System.currentTimeMillis();

        Group testStudentsGroup = new Group();
        testStudentsGroup.setName(testStudentsGroupName);

        queryCreator.addGroup(testStudentsGroup);

        Student testStudent = new Student();
        testStudent.setName(testStudentsName);
        testStudent.setGroup(testStudentsGroup);

        int testStudentId = testStudent.getId();
        //test CREATE student
        assertTrue(queryCreator.addStudent(testStudent));

        //test auto-generation id
        assertTrue(testStudent.getId() != testStudentId);


        //test error when add student with group not from DB
        try {
            Student testStudentWithGroupNotFromDB = new Student();
            testStudentWithGroupNotFromDB.setName(testStudentsName);
            testStudentWithGroupNotFromDB.setGroup(groupNotFromDB);
            queryCreator.addStudent(testStudentWithGroupNotFromDB);
            assertTrue(false);

        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test READ student
        Student addedStudent = queryCreator.getStudent(testStudent);

        assertEquals(testStudent.getId(), addedStudent.getId());
        assertEquals(testStudent.getName(), addedStudent.getName());
        assertEquals(testStudent, addedStudent);

        //test error when read invalid student
        Student studentNotFromDB = new Student();
        studentNotFromDB.setName(testStudentsName);
        studentNotFromDB.setGroup(testStudentsGroup);

        try {
            queryCreator.getStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test UPDATE student
        String newTestStudentName = "Student " + System.currentTimeMillis();
        testStudent.setName(newTestStudentName);

        assertTrue(queryCreator.editStudent(testStudent));

        Student updatedStudent = queryCreator.getStudent(testStudent);

        assertEquals(newTestStudentName, updatedStudent.getName());
        assertEquals(testStudent.getId(), updatedStudent.getId());
        assertEquals(testStudent.getGroup().getId(), updatedStudent.getGroup().getId());
        assertEquals(testStudent.getGroup().getName(), updatedStudent.getGroup().getName());

        //test error when update(student not from DB)
        try {
            queryCreator.editStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //test error when update(student from DB but new group not from db)
        testStudent.setGroup(groupNotFromDB);
        try {
            queryCreator.editStudent(testStudent);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }


        //test DELETE student
        assertNotNull(queryCreator.getStudent(testStudent));
        assertTrue(queryCreator.deleteStudent(testStudent));

        //try find deleted student
        try {
            queryCreator.getStudent(testStudent);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }

        //try deleted student not from DB
        try {
            queryCreator.deleteStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }
}