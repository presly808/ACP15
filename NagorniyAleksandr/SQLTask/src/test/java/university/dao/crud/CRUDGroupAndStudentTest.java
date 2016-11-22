package university.dao.crud;

import org.junit.Test;
import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.exceptions.AppDBException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;
import university.models.Group;
import university.models.Student;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CRUDGroupAndStudentTest extends PrepareTestDataBase {

    private static final DBConnector dbConnector;
    private static final QueryCreator queryCreator;

    static {
        dbConnector = new DBConnectorImpl();
        CRUDQuery crudQuery = new CRUDQueryImpl(dbConnector);
        queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);
    }

    @Test
    public void CRUDGroupAndStudents() throws Exception {

        String testGroupName = "Gr" + System.currentTimeMillis();
        int testGroupId = -1;

        Group testGroup = new Group(testGroupId, testGroupName);

        //test CREATE group
        assertTrue(queryCreator.addGroup(testGroup));

        //test auto-generation id
        assertTrue(testGroup.getId() != testGroupId);
        assertThat(testGroup.getId(), not(equalTo(testGroupId)));

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
        Group groupNotFromDB = new Group(invalidId, "Test");

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
        int testStudentsId = -1;

        String testStudentsGroupName = "Gr" + System.currentTimeMillis();
        int testStudentsGroupId = -1;
        Group testStudentsGroup = new Group(testStudentsGroupId, testStudentsGroupName);
        queryCreator.addGroup(testStudentsGroup);

        Student testStudent = new Student(testStudentsId, testStudentsName, testStudentsGroup);

        //test CREATE student
        assertTrue(queryCreator.addStudent(testStudent));

        //test auto-generation id
        assertTrue(testStudent.getId() != testStudentsId);


        //test error when add student with group not from DB
        try {
            queryCreator.addStudent(new Student(testStudentsId, testStudentsName, groupNotFromDB));
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
        int invalidStudentId = -1;
        Student studentNotFromDB = new Student(invalidId, testStudentsName, testStudentsGroup);

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