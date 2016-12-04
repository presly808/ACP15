package dao;

import init.StartInitJPADB;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import ua.artcode.dao.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by work on 04.12.2016.
 */
public class FixturesForTest {

    public static EntityManagerFactory managerFactory;
    public static DaoSubject daoSubject;
    public static DaoGroup daoGroup;
    public static DaoTeacher daoTeacher;
    public static DaoStudent daoStudent;

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

}
