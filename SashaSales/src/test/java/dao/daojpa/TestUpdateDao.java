package dao.daojpa;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.artcode.daojpa.*;
import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by work on 29.11.2016.
 */
public class TestUpdateDao {


    private static DaoSubject daoSubject;
    private static DaoGroup daoGroup;
    private static DaoTeacher daoTeacher;
    private static DaoStudent daoStudent;
    private static EntityManagerFactory managerFactory;

    @BeforeClass
    public static void connectManagerFactory(){
        managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        daoSubject = new DaoSubjectImplJPA(managerFactory);
        daoGroup = new DaoGroupImplJPA(managerFactory);
        daoStudent = new DaoStudentImplJPA(managerFactory);
        daoTeacher = new DaoTeacherImplJPA(managerFactory);
    }

    @AfterClass
    public static void closeManagerFactory(){
        managerFactory.close();
    }



    @Test
    public void testUpdateStudentByGroup(){

        Group group = new Group("Deputies");
        Group groupRes1 = (Group) daoGroup.create(group);
        Student student = new Student("Tamerlan");
        Student studentRes1 = (Student) daoStudent.create(student);
        Student studentRes2 = (Student) daoStudent.updateByGroup(student.getName(), group.getName());
        boolean res1 = daoStudent.delete(student);
        boolean res2 = daoGroup.delete(group);
        Assert.assertThat("Test method Update Student By Group", true, equalTo((studentRes1 != null && groupRes1 != null
                        && studentRes2 != null) && res2 && res1));

    }

}
