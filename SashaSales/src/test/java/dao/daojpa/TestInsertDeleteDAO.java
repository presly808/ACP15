package dao.daojpa;

import init.StartInitSQLDB;
import org.junit.*;
import ua.artcode.daoSQL.implementationssql.*;
import ua.artcode.daoSQL.interfaces.*;
import ua.artcode.daojpa.*;
import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;
import ua.artcode.model.modeljpa.Subject;
import ua.artcode.model.modeljpa.Teacher;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


/**
 * Created by work on 19.11.2016.
 */
public class TestInsertDeleteDAO {

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
    public void testAddDeleteGroups(){

        Group group = new Group("Gidrologia");
        Group groupRes1 = (Group) daoGroup.create(group);
        boolean res2 = daoGroup.delete(group);
        Assert.assertThat("Test method Create Delete Subject", true, equalTo((groupRes1 != null) && res2));

    }

    @Test
    public void testCreateDeleteSubject() {

        Subject subject = new Subject("Homosupiens", "Description Homosupiens");
        Subject subjectRes1 = (Subject) daoSubject.create(subject);
        boolean res2 = daoSubject.delete(subject);
        Assert.assertThat("Test method Create Delete Subject", true, equalTo((subjectRes1 != null) && res2));

    }

    @Test
    public void testCreateDeleteTeacher() {

        Subject subject = new Subject("Imunologia", "Description Imunologia");
        Teacher teacher = new Teacher("Timur", 2, subject);
        Teacher teacherRes1 = (Teacher) daoTeacher.create(teacher);
        boolean res1 = daoTeacher.delete(teacher);
        boolean res2 = daoSubject.delete(subject);
        Assert.assertThat("Test method Create Delete Subject", true, equalTo((teacherRes1 != null) && res2 && res1));

    }

    @Test
    public void testCreateDeleteStudent() {

        Group group = new Group("Deputies");
        Student student = new Student("Tamerlan", group);
        Student studentRes1 = (Student) daoStudent.create(student);
        boolean res1 = daoStudent.delete(student);
        boolean res2 = daoGroup.delete(group);
        Assert.assertThat("Test method Create Delete Subject", true, equalTo((studentRes1 != null) && res2 && res1));

    }



   /* @Test
    public void testAddDeleteFieldStudy(){

        String groupName = "RR12";
        String subjectName = "Terapia";
        boolean insertGroupResult =  insertDAO.addGroup(groupName);
        boolean insertSubjectResult =  insertDAO.addSubject(subjectName, "Description Terapia");
        boolean insertFieldStudyResult =  insertDAO.addFieldStudy(1, 1);
        boolean deleteFieldStudyResult =  deleteDAO.deleteFieldStudy(1, 1);
        boolean deleteSubjectResult = deleteDAO.deleteSubject(subjectName);
        boolean deleteGroupResult = deleteDAO.deleteGroup(groupName);

        Assert.assertThat("Test method Add and Delete Student", insertGroupResult && insertSubjectResult
            && insertFieldStudyResult && deleteFieldStudyResult && deleteSubjectResult && deleteGroupResult, not(false));

    }*/



}
