package university.dao.crud;

import org.junit.Test;
import university.exceptions.AppDBException;
import university.models.Group;
import university.models.Student;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CRUDGroupAndStudentTest extends PrepareTestDataBase {

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

        assertThat(testGroup.getId(), equalTo(addedGroup.getId()));
        assertThat(testGroup.getName(), equalTo(addedGroup.getName()));
        assertThat(testGroup, equalTo(addedGroup));

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

        assertThat(newTestGroupName, equalTo(updatedGroup.getName()));
        assertThat(testGroup.getId(), equalTo(updatedGroup.getId()));

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
        assertThat(testStudent.getId(), not(equalTo(testStudentId)));

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

        assertThat(testStudent.getId(), equalTo(addedStudent.getId()));
        assertThat(testStudent.getName(), equalTo(addedStudent.getName()));
        assertThat(testStudent, equalTo(addedStudent));

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

        assertThat(newTestStudentName, equalTo(updatedStudent.getName()));
        assertThat(testStudent.getId(), equalTo(updatedStudent.getId()));
        assertThat(testStudent.getGroup().getId(), equalTo(updatedStudent.getGroup().getId()));
        assertThat(testStudent.getGroup().getName(), equalTo(updatedStudent.getGroup().getName()));

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

        //clear test data
        queryCreator.deleteGroup(testStudentsGroup);
    }
}