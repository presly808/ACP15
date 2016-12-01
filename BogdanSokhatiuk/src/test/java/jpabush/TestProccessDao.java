package jpabush;

import jpabush.dao.StadyProccessDao;
import jpabush.model.Group;
import jpabush.model.StadyProccess;
import jpabush.model.Student;
import jpabush.model.Subject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lost on 01.12.2016.
 */
public class TestProccessDao extends DaoTextureTest {
    private StadyProccessDao dao;
    private Student student1;
    private Student student2;
    private Student student3;
    private Subject subject;
    private Subject subject1;
    private Subject subject2;
    private StadyProccess proccess;
    private StadyProccess proccess1;
    private StadyProccess proccess2;


    @Before
    public void init() {
        dao = new StadyProccessDao(manager);

        student1 = new Student(555, "Ivan", new Group("APC15", 322));
        student2 = new Student(666, "Kiril", new Group("APC15", 322));
        student3 = new Student(777, "Taras", new Group("APC15", 322));
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        subject = new Subject(68, "Matimatics", "Math");
        subject1 = new Subject(68, "Economica", "Ec");
        subject2 = new Subject(68, "Information Technology", "IT");
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject);
        subjectList.add(subject1);
        subjectList.add(subject2);
        proccess = new StadyProccess(student1, subject, 95);
        proccess = dao.create(proccess);

    }

    @Test
    public void TestBestStudent() {
        List<Student> list = dao.getBestStudent();
        MatcherAssert.assertThat(list.size(), Matchers.equalTo(6));
    }

    @After
    public void setDown() {
        dao.delete(proccess, proccess.getId());
    }


}
