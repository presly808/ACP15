package dao;

import init.StartInitDB;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

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

    private static CreateDAO createDAO = null;
    private static InsertDAO insertDAO = null;
    private static UpdateDAO updateDAO = null;
    private static SelectDAO selectDAO = null;
    private static DropDAO dropDAO = null;

    @BeforeClass
    public static void classSetUp(){
        createDAO = new CreateCommands();
        insertDAO = new InsertCommands();
        selectDAO = new SelectCommands();
        updateDAO = new UpDateCommands();
        dropDAO = new DropCommands();
        StartInitDB.createTables(createDAO);
        StartInitDB.initTables(insertDAO, updateDAO);
    }

    @AfterClass
    public static void finished(){
        StartInitDB.dropTables(dropDAO);
    }


    @Test
    public void testGetStudents(){

        List<Student> studentList = selectDAO.getStudents();
        int size = studentList.size();
        Assert.assertThat("Test method Add and Delete Groups", 60, equalTo(size));
    }

    @Test
    public void testGetTeachersThatWorkMore3Years(){

        List<Teacher> teacherList = selectDAO.getTeachersThatWorkMore3Years();
        Assert.assertThat("Test method Get Teachers That Work More 3 Years ", 6, equalTo(teacherList.size()));
    }

    @Test
    public void testGetStudentsByGroup(){

        List<Student> studentList = selectDAO.getStudentsByGroup("ACP16");
        int size = studentList.size();
        Assert.assertThat("Test method Get Students By Group", 6,  equalTo(size));

    }

    @Test
    public void testGetGroupsThatStudySubject(){

        String subjectName = "Mathematics";
        List<Group> groupsList = selectDAO.getGroupsThatStudySubject(subjectName);
        int size = groupsList.size();
        Assert.assertThat("Test method Get Groups That Study Subject ", 1,  equalTo(size));

    }

    @Test
    public void testAvgMarkBySubjectInUniversity(){

        String subjectName = "Mathematics";
        double avgMark = selectDAO.avgMarkBySubjectInUniversity(subjectName);
        System.out.println(avgMark);
        Assert.assertThat("Test method Get Avg Mark By Subject In University ", avgMark, greaterThan(0.0));

    }

    @Test
    public void testAvgMarkBySubjectInGroup(){

        String subjectName = "Music";
        String groupName = "Base16";
        double avgMark1 = selectDAO.avgMarkBySubjectInGroup(groupName, subjectName);
        System.out.println(avgMark1);
        Assert.assertThat("Test method Get Avg Mark By Subject In University ", avgMark1,  not(0));

    }

}
