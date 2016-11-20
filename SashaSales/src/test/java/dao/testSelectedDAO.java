package dao;

import init.StartInitDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.daoSQL.implementations.*;
import ua.artcode.daoSQL.interfaces.*;
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
        System.out.println(studentList.size());
        Assert.assertEquals("Test method Add and Delete Groups", true, size > 15);

    }

    @Test
    public void testGetTeachersThatWorkMore3Years(){

        List<Teacher> teacherList = selectDAO.getTeachersThatWorkMore3Years();
        System.out.println("Quantity Teachers That Work More 3 Years - " + teacherList.size());

        Assert.assertEquals("Test method Get Teachers That Work More 3 Years ", true, teacherList.size() > 2);
    }

    @Test
    public void testGetStudentsByGroup(){

        List<Student> studentList = selectDAO.getStudentsByGroup("Base12");
        int size = studentList.size();
        Assert.assertEquals("Test method Get Students By Group", true,  size == 6 || size == 5);

    }

}
