package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.artcode.daoSQL.implementations.CreateCommands;
import ua.artcode.daoSQL.implementations.DropCommands;
import ua.artcode.daoSQL.interfaces.CreateDAO;
import ua.artcode.daoSQL.interfaces.DropDAO;
import ua.artcode.util.Contstants;

import static org.hamcrest.Matchers.not;

/**
 * Created by work on 19.11.2016.
 */
public class TestCreateDropDAO {

    private static CreateDAO createDAO;
    private static DropDAO dropDAO;

    @BeforeClass
    public static void setUP(){
            createDAO = new CreateCommands();
            dropDAO = new DropCommands();
    }


    @Test
    public void testCreateDropGroups(){

        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
        Assert.assertThat("Test method Create Table Groups", createTableGroupsResult && dropTableGroupsResult, not(false));

    }

    @Test
    public void testCreateDropSubject(){

        boolean createTableSubjectResult = createDAO.createTableSubject();
        boolean dropTableSubjectResult = dropDAO.dropTableSubjects();
        Assert.assertThat("Test method Create Table Subjects", createTableSubjectResult && dropTableSubjectResult, not(false));

    }

    @Test
    public void testCreateDropTeachers(){

        boolean createTableSubjectResult = createDAO.createTableSubject();
        boolean createTableTeachersResult = createDAO.createTableTeachers();
        boolean dropTableTeachersResult = dropDAO.dropTableTeachers();
        boolean dropTableSubjectsResult = dropDAO.dropTableSubjects();
        Assert.assertThat("Test method Create Table Subjects", createTableTeachersResult && createTableSubjectResult
                && dropTableSubjectsResult && dropTableTeachersResult, not(false));

    }

    @Test
    public void testCreateDropStudents(){

        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean createTableStudentsResult = createDAO.createTableStudents();
        boolean dropTableStudentsResult = dropDAO.dropTableStudents();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
        Assert.assertThat("Test method Create Table Students", createTableStudentsResult && createTableGroupsResult
                && dropTableGroupsResult && dropTableStudentsResult, not(false));
    }

    @Test
    public void testCreateDropStudy(){

        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean createTableSubjectsResult = createDAO.createTableSubject();
        boolean createTableStudyResult = createDAO.createTableStudy();
        boolean dropTableStudyResult = dropDAO.dropTableStudy();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
        boolean dropTableSubjectsResult = dropDAO.dropTableSubjects();
        Assert.assertThat("Test method Create Table Groups", createTableStudyResult
                && createTableGroupsResult && createTableSubjectsResult
                    && dropTableGroupsResult && dropTableStudyResult && dropTableSubjectsResult, not(false));
    }

    @Test
    public void testCreateDropMarks(){

        boolean createTableGroupsResult = createDAO.createTableGroups();
        boolean createTableSubjectsResult = createDAO.createTableSubject();
        boolean createTableStudentsResult = createDAO.createTableStudents();
        boolean createTableStudyResult = createDAO.createTableStudy();
        boolean createTableMarkResult = createDAO.createTableMarks();
        boolean dropTableMarkResult = dropDAO.dropTableMarks();
        boolean dropTableStudyResult = dropDAO.dropTableStudy();
        boolean dropTableStudentsResult = dropDAO.dropTableStudents();
        boolean dropTableGroupsResult = dropDAO.dropTableGroups();
        boolean dropTableSubjectsResult = dropDAO.dropTableSubjects();
        Assert.assertThat("Test method Create Table Groups", createTableStudyResult && createTableStudentsResult
                && createTableGroupsResult && createTableSubjectsResult && createTableMarkResult && dropTableStudentsResult
                && dropTableGroupsResult && dropTableStudyResult && dropTableSubjectsResult && dropTableMarkResult, not(false));
    }

}
