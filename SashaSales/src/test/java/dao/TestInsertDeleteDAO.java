package dao;


import org.junit.Assert;
import org.junit.Test;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import static org.hamcrest.Matchers.equalTo;


public class TestInsertDeleteDAO extends FixturesForTest {


    @Test
    public void testAddDeleteGroups(){

        Group group = new Group("Vedushie");
        Group groupRes1 = (Group) daoGroup.create(group);
        boolean res2 = daoGroup.delete(group.getName());
        Assert.assertThat("Test method Create Delete Groups", true, equalTo((groupRes1 != null) && res2));

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

        Subject subject = new Subject("Phisica", "Description Phisica");
        Teacher teacher = new Teacher("Timurchik", 2, subject);
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
