package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.daoSQL.implementations.CreateCommands;
import ua.artcode.daoSQL.implementations.DropCommands;
import ua.artcode.daoSQL.interfaces.CreateDAO;
import ua.artcode.daoSQL.interfaces.DropDAO;
import ua.artcode.util.Contstants;

/**
 * Created by work on 19.11.2016.
 */
public class TestCreateDropDAO {

    private CreateDAO createDAO;
    private DropDAO dropDAO;

    @Before
    public void setUP(){
            createDAO = new CreateCommands();
            dropDAO = new DropCommands();

    }


    @Test
    public void testCreateDropGroups(){

        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
        Assert.assertEquals("Test method Create Table Groups", true, createTableGroupsResult && dropTableGroupsResult);

    }

    @Test
    public void testCreateDropSubject(){

        boolean createTableSubjectResult = createDAO.createTableSubject();
        boolean dropTableSubjectResult = dropDAO.dropTableSubjects();
        Assert.assertEquals("Test method Create Table Subjects", true, createTableSubjectResult && dropTableSubjectResult);

    }

    @Test
    public void testCreateDropTeachers(){

        boolean createTableSubjectResult = createDAO.createTableSubject();
        boolean createTableTeachersResult = createDAO.createTableTeachers();
        boolean dropTableTeachersResult = dropDAO.dropTableTeachers();
        boolean dropTableSubjectsResult = dropDAO.dropTableSubjects();
        Assert.assertEquals("Test method Create Table Subjects", true, createTableTeachersResult && createTableSubjectResult
                && dropTableSubjectsResult && dropTableTeachersResult);

    }

    @Test
    public void testCreateDropStudents(){

        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean createTableStudentsResult = createDAO.createTableStudents();
        boolean dropTableStudentsResult = dropDAO.dropTableStudents();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
        Assert.assertEquals("Test method Create Table Students", true, createTableStudentsResult && createTableGroupsResult
                && dropTableGroupsResult && dropTableStudentsResult);
    }

    @Test
    public void testCreateDropStudy(){

        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean createTableSubjectsResult = createDAO.createTableSubject();
        boolean createTableStudyResult = createDAO.createTableStudy();
        boolean dropTableStudyResult = dropDAO.dropTableStudy();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
        boolean dropTableSubjectsResult = dropDAO.dropTableSubjects();
        Assert.assertEquals("Test method Create Table Groups", true, createTableStudyResult
                && createTableGroupsResult && createTableSubjectsResult
                    && dropTableGroupsResult && dropTableStudyResult && dropTableSubjectsResult);
    }
}
