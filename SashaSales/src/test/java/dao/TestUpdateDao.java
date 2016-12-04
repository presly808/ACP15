package dao;

import org.junit.Assert;
import org.junit.Test;
import ua.artcode.model.Group;
import ua.artcode.model.Student;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by work on 29.11.2016.
 */
public class TestUpdateDao extends FixturesForTest {

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
