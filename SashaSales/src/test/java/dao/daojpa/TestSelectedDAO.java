package dao.daojpa;

import init.StartInitJPADB;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.artcode.daojpa.*;
import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;
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
    private static DaoStudent daoStudent;
    private static EntityManagerFactory managerFactory;

    @BeforeClass
    public static void connectManagerFactory(){
        managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        daoSubject = new DaoSubjectImplJPA(managerFactory);
        daoStudent = new DaoStudentImplJPA(managerFactory);
        daoGroup = new DaoGroupImplJPA(managerFactory);
        daoTeacher = new DaoTeacherImplJPA(managerFactory);
        StartInitJPADB.initTables(daoGroup, daoSubject, daoTeacher, daoStudent, managerFactory);
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

    @Test
    public void testGetstudents(){

        List<Student> studentList = daoStudent.getAllStudents();
        Assert.assertThat("Test method get All Students", 60, equalTo(studentList.size()));

    }


}
