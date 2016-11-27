package dao.daojpa;

import init.StartInitJPADB;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.artcode.daojpa.*;
import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Subject;
import ua.artcode.model.modeljpa.Teacher;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by work on 19.11.2016.
 */
public class TestSelectedDAO {

    private static DaoSubject daoSubject;
    private static DaoGroup daoGroup;
    private static DaoTeacher daoTeacher;
    private static EntityManagerFactory managerFactory;

    @BeforeClass
    public static void connectManagerFactory(){
        managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        daoSubject = new DaoSubjectImplJPA(managerFactory);
        daoGroup = new DaoGroupImplJPA(managerFactory);
        daoTeacher = new DaoTeacherImplJPA(managerFactory);
        StartInitJPADB.initTables(daoGroup, daoTeacher);
    }

    @AfterClass
    public static void closeManagerFactory(){
        managerFactory.close();
    }


    @Test
    public void testGetSubjects(){

        List<Subject> subjectList = daoSubject.getAllSubject();
        Assert.assertThat("Test method get All Subject", 20, equalTo(subjectList.size()));

    }

    @Test
    public void testGetGroups(){

        List<Group> groupList = daoGroup.getAllGroup();
        Assert.assertThat("Test method get All Groups", 10, equalTo(groupList.size()));

    }

    @Test
    public void testGetTeachers(){

        List<Teacher> teacherList = daoTeacher.getAllTeacher();
        Assert.assertThat("Test method get All Teachers", 20, equalTo(teacherList.size()));

    }


   /* @Test
    public void testGetStudents(){

        List<Student> studentList = selectDAO.getStudents();
        int size = studentList.size();
        Assert.assertThat("Test method Add and Delete Groups", 60, equalTo(size));
    }
*/
   /* @Test
    public void testGetTeachersThatWorkMore3Years(){

        List<Teacher> teacherList = selectDAO.getTeachersThatWorkMore3Years();
        Assert.assertThat("Test method Get Teachers That Work More 3 Years ", 6, equalTo(teacherList.size()));
    }
*/
    /*@Test
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
        Assert.assertThat("Test method Get Groups That Study Subject ", 2,  equalTo(size));

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
        double avgMark = selectDAO.avgMarkBySubjectInGroup(groupName, subjectName);
        System.out.println(avgMark);
        Assert.assertThat("Test method Get Avg Mark By Subject In University ", avgMark, greaterThan(0.0));

    }
*/
}
