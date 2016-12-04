
package dao;

import init.StartInitJPADB;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.artcode.dao.*;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;


public class TestSelectedDAO extends FixturesForTest {

    private static EntityManagerFactory managerFactory;
    private static DaoSubject daoSubject;
    private static DaoGroup daoGroup;
    private static DaoTeacher daoTeacher;
    private static DaoStudent daoStudent;

    @BeforeClass
    public static void connectManagerFactory(){
        managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        daoSubject = new DaoSubjectImplJPA(managerFactory);
        daoGroup = new DaoGroupImplJPA(managerFactory);
        daoStudent = new DaoStudentImplJPA(managerFactory);
        daoTeacher = new DaoTeacherImplJPA(managerFactory);
        StartInitJPADB.initTables(daoGroup, daoSubject, daoTeacher, daoStudent, managerFactory);
    }

    @AfterClass
    public static void closeManagerFactory(){
        managerFactory.close();
    }



    @Test
    public void testGetSubjects() {

        List<Subject> subjectList = daoSubject.getAll();
        Assert.assertThat("Test method get All Subject", 20, equalTo(subjectList.size()));

    }

    @Test
    public void testGetGroups() {

        List<Group> groupList = daoGroup.getAll();
        Assert.assertThat("Test method get All Groups", 10, equalTo(groupList.size()));

    }

    @Test
    public void testGetTeachers() {

        List<Teacher> teacherList = daoTeacher.getAll();
        Assert.assertThat("Test method get All Teachers", 20, equalTo(teacherList.size()));

    }

    @Test
    public void testGetstudents() {

        List<Student> studentList = daoStudent.getAll();
        Assert.assertThat("Test method get All Students", 60, equalTo(studentList.size()));

    }

    @Test
    public void testGetGroupBySubject() {

        List<Group> groupList = daoGroup.getGroupsThatStudySubject("History");
        Assert.assertThat("Test method get Group By Subject", 7, equalTo(groupList.size()));

    }

}
