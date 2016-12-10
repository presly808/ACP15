package dao;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.artcode.dao.DaoGroup;
import ua.artcode.dao.DaoStudent;
import ua.artcode.dao.DaoSubject;
import ua.artcode.dao.DaoTeacher;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;
import ua.artcode.service.IService;

import javax.persistence.EntityManagerFactory;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-test-context.xml"})
public class TestInsertDeleteDAO{

    @Autowired
    private IService service;
    @Autowired
    private DaoSubject daoSubject;
    @Autowired
    private DaoGroup daoGroup;
    @Autowired
    private DaoTeacher daoTeacher;
    @Autowired
    private DaoStudent daoStudent;


    @Test
    public void testAddDeleteGroups(){

        Group group = new Group("VedushieVremya");
        Group groupRes1 = (Group) daoGroup.create(group);
        boolean res2 = daoGroup.delete(group.getName());
        Assert.assertThat("Test method Create Delete Groups", true, equalTo((groupRes1 != null) && res2));

    }

    @Test
    public void testServiceAddDeleteGroups() throws EmptyException {

        String group_name = "VedushieVremya111";
        Group groupRes1 = service.addGroup(group_name);
        boolean res2 = daoGroup.delete(group_name);
        Assert.assertThat("Test method Service Create Delete Groups", true, equalTo(groupRes1 != null && res2 && group_name.equals(groupRes1.getName())));

    }

    @Test
    public void testCreateDeleteSubject() {

        Subject subject = new Subject("Tech", "Description Tech");
        Subject subjectRes1 = (Subject) daoSubject.create(subject);
        boolean res2 = daoSubject.delete(subject.getName());
        Assert.assertThat("Test method Create Delete Subject", true, equalTo((subjectRes1 != null) && res2));

    }

    @Test
    public void testCreateDeleteTeacher() {

        Subject subject = new Subject("Phisica2", "Description Phisica");
        Teacher teacher = new Teacher("Timurchik2", 2, subject);
        Teacher teacherRes1 = (Teacher) daoTeacher.create(teacher);
        boolean res1 = daoTeacher.delete(teacher.getName());
        boolean res2 = daoSubject.delete(subject.getName());
        Assert.assertThat("Test method Create Delete Teacher", true, equalTo((teacherRes1 != null) && res2 && res1));

    }

    @Test
    public void testCreateDeleteStudent() {

        Group group = new Group("DeputiesForUkraine");
        Student student = new Student("Druzb", group);
        Student studentRes1 = (Student) daoStudent.create(student);
        boolean res1 = daoStudent.delete(student.getName());
        boolean res2 = daoGroup.delete(group.getName());
        Assert.assertThat("Test method Create Delete Student", true, equalTo((studentRes1 != null) && res2 && res1));

    }

}
