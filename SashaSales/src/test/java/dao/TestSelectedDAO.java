
package dao;

import init.StartInitJPADB;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.artcode.dao.*;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-test-context.xml"})
public class TestSelectedDAO {

    @Autowired
    private DaoSubject daoSubject;
    @Autowired
    private DaoGroup daoGroup;
    @Autowired
    private DaoTeacher daoTeacher;
    @Autowired
    private DaoStudent daoStudent;

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

    @Test
    public void testGet() {

        List<Group> groupList = daoGroup.getFirstLimitResuliList(4, 5);
        Assert.assertThat("Test method get First 2 Group By GroupList From 4 Element", 2, equalTo(groupList.size()));

    }

}
