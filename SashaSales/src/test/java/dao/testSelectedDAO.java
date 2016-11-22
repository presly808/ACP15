package dao;

import init.StartInitDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.daoSQL.implementations.*;
import ua.artcode.daoSQL.interfaces.*;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Teacher;

import java.util.List;

/**
 * Created by work on 19.11.2016.
 */
public class TestSelectedDAO {

    private CreateDAO createDAO = null;
    private InsertDAO insertDAO = null;
    private UpdateDAO updateDAO = null;
    private SelectDAO selectDAO = null;
    private DeleteDAO deleteDAO = null;
    private DropDAO dropDAO = null;

    @Before
    public void setUP(){

        createDAO = new CreateCommands();
        deleteDAO = new DeleteCommands();
        insertDAO = new InsertCommands();
        selectDAO = new SelectCommands();
        updateDAO = new UpDateCommands();
        dropDAO = new DropCommands();
        StartInitDB.createTables(createDAO);
        StartInitDB.initTables(insertDAO, updateDAO);
    }

    @After
    public void finished(){
        StartInitDB.dropTables(dropDAO);
    }


    @Test
    public void testGetStudents(){

        List<Student> studentList = selectDAO.getStudents();
        int size = studentList.size();
        Assert.assertEquals("Test method Add and Delete Groups", true, size == 60);

    }

    @Test
    public void testGetTeachersThatWorkMore3Years(){

        List<Teacher> teacherList = selectDAO.getTeachersThatWorkMore3Years();
        Assert.assertEquals("Test method Get Teachers That Work More 3 Years ", true, teacherList.size() == 6);
    }

    @Test
    public void testGetStudentsByGroup(){

        List<Student> studentList = selectDAO.getStudentsByGroup("ACP16");
        int size = studentList.size();
        Assert.assertEquals("Test method Get Students By Group", true,  size == 6);

    }

    @Test
    public void testGetGroupsThatStudySubject(){

        String subjectName = "Mathematics";
        List<Group> groupsList = selectDAO.getGroupsThatStudySubject(subjectName);
        int size = groupsList.size();
        Assert.assertEquals("Test method Get Groups That Study Subject ", true,  size == 2);

    }

    @Test
    public void testAvgMarkBySubjectInUniversity(){

        String subjectName = "Mathematics";
        double avgMark = selectDAO.avgMarkBySubjectInUniversity(subjectName);
        System.out.println(avgMark);
        Assert.assertEquals("Test method Get Avg Mark By Subject In University ", true,  avgMark != 0);

    }

    @Test
    public void testAvgMarkBySubjectInGroup(){

        String subjectName = "Journalism";
        String groupName = "Base16";
        double avgMark = selectDAO.avgMarkBySubjectInGroup(groupName, subjectName);
        System.out.println(avgMark);
        Assert.assertEquals("Test method Get Avg Mark By Subject In University ", true,  avgMark != 0);

    }

}
