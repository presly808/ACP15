
package university.dao.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import university.container.Factory;
import university.dao.QueryCreator;
import university.exceptions.AppDBException;
import university.models.Group;
import university.models.Student;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CRUDQueryStudentTest extends PrepareTestDataBase {

    private Group testStudentsGroup;
    private Group groupNotFromDB;

    private Student testStudent;
    private Student studentNotFromDB;

    @Before
    public void setUp() throws Exception {

        String testStudentsGroupName = "Gr" + System.currentTimeMillis();

        testStudentsGroup = new Group();
        testStudentsGroup.setName(testStudentsGroupName);
        queryCreator.addGroup(testStudentsGroup);

        String testStudentsName = "Student " + System.currentTimeMillis();

        testStudent = new Student();
        testStudent.setName(testStudentsName);
        testStudent.setGroup(testStudentsGroup);
        queryCreator.addStudent(testStudent);

        groupNotFromDB = new Group();
        groupNotFromDB.setName("Gr" + System.currentTimeMillis());

        int invalidStudentId = -1;
        studentNotFromDB = new Student();
        studentNotFromDB.setId(invalidStudentId);
        studentNotFromDB.setName(testStudentsName);
        studentNotFromDB.setGroup(testStudentsGroup);
        studentNotFromDB.setId(invalidStudentId);
    }

    @After
    public void tearDown() throws Exception {
        try {
            queryCreator.deleteStudent(testStudent);
        } catch (AppDBException e) {}

        try {
            queryCreator.deleteGroup(testStudentsGroup);
        } catch (AppDBException e) {}

        studentNotFromDB = null;
        groupNotFromDB = null;
    }

    @Test
    public void addStudent() throws Exception {
        String testStudentsNameForAddTest = "Student " + System.currentTimeMillis();

        Student testStudentForAddTest = new Student();
        testStudentForAddTest.setName(testStudentsNameForAddTest);
        testStudentForAddTest.setGroup(testStudentsGroup);

        assertTrue(queryCreator.addStudent(testStudentForAddTest));

        //test auto-generation id
        int defaultStudentId = 0;
        assertThat(testStudentForAddTest.getId(), not(equalTo(defaultStudentId)));

        queryCreator.deleteStudent(testStudentForAddTest);
    }

    @Test
    public void addStudentNegative() throws Exception {

        String testStudentsName = "Name";
        Student studentWithInvalidGroup = new Student();
        studentWithInvalidGroup.setName(testStudentsName);
        studentWithInvalidGroup.setGroup(groupNotFromDB);

        try {
            queryCreator.addStudent(studentWithInvalidGroup);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editStudent() throws Exception {
        String newTestStudentName = "Student " + System.currentTimeMillis();
        testStudent.setName(newTestStudentName);

        assertTrue(queryCreator.editStudent(testStudent));

        Student updatedStudent = queryCreator.getStudent(testStudent);

        assertThat(newTestStudentName, equalTo(updatedStudent.getName()));
        assertThat(testStudent.getId(), equalTo(updatedStudent.getId()));
        assertThat(testStudent.getGroup().getId(), equalTo(updatedStudent.getGroup().getId()));
        assertThat(testStudent.getGroup().getName(), equalTo(updatedStudent.getGroup().getName()));
    }

    @Test
    public void editStudentNegativeInvalidNewData() throws Exception {
        testStudent.setGroup(groupNotFromDB);
        try {
            queryCreator.editStudent(testStudent);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editStudentNegativeStudentNotFromDB() throws Exception {
        try {
            queryCreator.editStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteStudent() throws Exception {
        assertNotNull(queryCreator.getStudent(testStudent));
        assertTrue(queryCreator.deleteStudent(testStudent));

        try {
            queryCreator.getStudent(testStudent);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void deleteStudentNegative() throws Exception {
        try {
            queryCreator.deleteStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getStudent() throws Exception {
        Student addedStudent = queryCreator.getStudent(testStudent);

        assertThat(testStudent.getId(), equalTo(addedStudent.getId()));
        assertThat(testStudent.getName(), equalTo(addedStudent.getName()));
        assertThat(testStudent, equalTo(addedStudent));
    }

    @Test
    public void getStudentNegative() throws Exception {
        try {
            queryCreator.getStudent(studentNotFromDB);
            assertTrue(false);
        } catch (AppDBException e) {
            assertTrue(true);
        }
    }

}
