package dao;

import init.StartInitDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.daoSQL.implementations.CreateCommands;
import ua.artcode.daoSQL.implementations.DeleteCommands;
import ua.artcode.daoSQL.implementations.DropCommands;
import ua.artcode.daoSQL.implementations.InsertCommands;
import ua.artcode.daoSQL.interfaces.CreateDAO;
import ua.artcode.daoSQL.interfaces.DeleteDAO;
import ua.artcode.daoSQL.interfaces.DropDAO;
import ua.artcode.daoSQL.interfaces.InsertDAO;

import static org.hamcrest.Matchers.not;


/**
 * Created by work on 19.11.2016.
 */
public class TestInsertDeleteDAO {

    private CreateDAO createDAO = null;
    private InsertDAO insertDAO = null;
    private DeleteDAO deleteDAO = null;
    private DropDAO dropDAO = null;

    @Before
    public void setUP(){

        createDAO = new CreateCommands();
        deleteDAO = new DeleteCommands();
        insertDAO = new InsertCommands();
        dropDAO = new DropCommands();
        StartInitDB.createTables(createDAO);
    }

    @After
    public void finished(){
        StartInitDB.dropTables(dropDAO);
    }


    @Test
    public void testAddDeleteGroups(){

        String groupName = "RR12";
        boolean insertGroupResult =  insertDAO.addGroup(groupName);
        boolean deleteGroupResult = deleteDAO.deleteGroup(groupName);
        Assert.assertThat("Test method Add and Delete Groups", insertGroupResult && deleteGroupResult, not(false));

    }

    @Test
    public void testAddDeleteSubject(){

        String subjectName = "Terapia";
        boolean insertSubjectResult =  insertDAO.addSubject(subjectName, "Description Terapia");
        boolean deleteSubjectResult = deleteDAO.deleteSubject(subjectName);

        Assert.assertThat("Test method Add and Delete subject", insertSubjectResult && deleteSubjectResult, not(false));

    }

    @Test
    public void testAddDeleteTeacher(){

        String subjectName = "Terapia";
        String teacherName = "Grigor";
        boolean insertSubjectResult =  insertDAO.addSubject(subjectName, "Description Terapia");
        boolean insertTeacherResult = insertDAO.addTeacher(teacherName, 3, 1);
        boolean deleteTeacherResult = deleteDAO.deleteTeacher(teacherName);
        boolean deleteSubjectResult = deleteDAO.deleteSubject(subjectName);
        Assert.assertEquals("Test method Add and Delete Teacher", true, insertSubjectResult && insertTeacherResult
                                && deleteTeacherResult && deleteSubjectResult);

    }

    @Test
    public void testAddDeleteStudent(){

        String studentName = "Grigor";
        boolean insertStudentResult =  insertDAO.addStudent(studentName);
        boolean deleteStudentResult = deleteDAO.deleteStudent(studentName);
        Assert.assertEquals("Test method Add and Delete Student", true, insertStudentResult && deleteStudentResult);

    }

    @Test
    public void testAddDeleteFieldStudy(){

        String groupName = "RR12";
        String subjectName = "Terapia";
        boolean insertGroupResult =  insertDAO.addGroup(groupName);
        boolean insertSubjectResult =  insertDAO.addSubject(subjectName, "Description Terapia");
        boolean insertFieldStudyResult =  insertDAO.addFieldStudy(1, 1);
        boolean deleteFieldStudyResult =  deleteDAO.deleteFieldStudy(1, 1);
        boolean deleteSubjectResult = deleteDAO.deleteSubject(subjectName);
        boolean deleteGroupResult = deleteDAO.deleteGroup(groupName);

        Assert.assertEquals("Test method Add and Delete Student", true, insertGroupResult && insertSubjectResult
            && insertFieldStudyResult && deleteFieldStudyResult && deleteSubjectResult && deleteGroupResult);

    }


}
