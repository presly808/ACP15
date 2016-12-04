package dao;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.artcode.dao.DaoGroup;
import ua.artcode.dao.DaoStudent;
import ua.artcode.dao.DaoSubject;
import ua.artcode.dao.DaoTeacher;
import ua.artcode.model.Group;
import ua.artcode.model.Student;

import javax.persistence.EntityManagerFactory;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-test-context.xml"})
public class TestUpdateDao {

    @Autowired
    public  EntityManagerFactory managerFactory;
    @Autowired
    public  DaoGroup daoGroup;
    @Autowired
    public  DaoStudent daoStudent;

    @Test
    public void testUpdateStudentByGroup(){

        Group group = new Group("Deputy");
        Group groupRes1 = (Group) daoGroup.create(group);
        Student student = new Student("Tamerlano");
        Student studentRes1 = (Student) daoStudent.create(student);
        Student studentRes2 = (Student) daoStudent.updateByGroup(student.getName(), group.getName());
        boolean res1 = daoStudent.delete(student.getName());
        boolean res2 = daoGroup.delete(group.getName());
        Assert.assertThat("Test method Update Student By Group", true, equalTo((studentRes1 != null && groupRes1 != null
                        && studentRes2 != null) && res2 && res1));

    }

}
