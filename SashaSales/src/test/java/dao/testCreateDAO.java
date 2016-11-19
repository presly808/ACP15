package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.daoSQL.implementations.CreateCommands;
import ua.artcode.daoSQL.implementations.DropCommands;
import ua.artcode.daoSQL.interfaces.CreateDAO;
import ua.artcode.daoSQL.interfaces.DropDAO;
import ua.artcode.util.IO;
import ua.artcode.util.PropertiesHolder;
import ua.artcode.util.UtilMethods;

/**
 * Created by work on 19.11.2016.
 */
public class testCreateDAO {

    private static final String testNameDB = "testcreatedb";
    private CreateDAO createDAO;
    private DropDAO dropDAO;

    @Before
    public void setUP(){
        createDAO = new CreateCommands();
        dropDAO = new DropCommands();
    }

    /*@Test
    public void testCreateDBSQL(){

        PropertiesHolder.addProperty(testNameDB);
        boolean createDBSQLResult = createDAO.createDBSQL(testNameDB);
        Assert.assertEquals("Test method Create DB SQL", true, false);
    //    dropDAO.dropDATABASE(testNameDB);
    }*/

    @Test
    public void testCreateTableGroups(){

        UtilMethods.useDBorCreate(testNameDB);
        boolean createTableGroupsResult = createDAO.createTableGroups();
        Assert.assertEquals("Test method Create Table Groups", true, createTableGroupsResult);
        dropDAO.dropTableGroups();
        //dropDAO.dropDATABASE(testNameDB);
    }

    @Test
    public void testCreateTableSubject(){

        UtilMethods.useDBorCreate(testNameDB);
        boolean createTableSubjectResult = createDAO.createTableSubject();
        Assert.assertEquals("Test method Create Table Subjects", true, createTableSubjectResult);
        dropDAO.dropTableSubjects();
       // dropDAO.dropDATABASE(testNameDB);
    }

    @Test
    public void testCreateTableTeachers(){

        UtilMethods.useDBorCreate(testNameDB);
        boolean createTableSubjectResult = createDAO.createTableSubject();
        boolean createTableTeachersResult = createDAO.createTableTeachers();
        Assert.assertEquals("Test method Create Table Subjects", true, createTableTeachersResult && createTableSubjectResult);
        dropDAO.dropTableSubjects();
        dropDAO.dropTableTeachers();
       // dropDAO.dropDATABASE(testNameDB);

    }

    @Test
    public void testCreateTableStudents(){

        UtilMethods.useDBorCreate(testNameDB);
        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean createTableStudentsResult = createDAO.createTableStudents();
        Assert.assertEquals("Test method Create Table Students", true, createTableStudentsResult && createTableGroupsResult);
        boolean dropTableStudentsResult = dropDAO.dropTableStudents();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
        //dropDAO.dropDATABASE(testNameDB);

    }

    @Test
    public void testCreateTableStudy(){

        UtilMethods.useDBorCreate(testNameDB);
        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean createTableSubjectsResult = createDAO.createTableSubject();
        boolean createTableStudyResult = createDAO.createTableStudy();
        Assert.assertEquals("Test method Create Table Groups", true, createTableStudyResult
                && createTableGroupsResult && createTableSubjectsResult);
        boolean dropTableStudyResult = dropDAO.dropTableStudy();
        boolean dropTableSubjectsResult = dropDAO.dropTableSubjects();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
    }

}
