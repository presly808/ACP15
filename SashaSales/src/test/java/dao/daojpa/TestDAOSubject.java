
package dao.daojpa;

import init.StartInitSQLDB;
import org.junit.*;
import ua.artcode.daoSQL.implementationssql.*;
import ua.artcode.daoSQL.interfaces.*;
import ua.artcode.daojpa.DaoSubject;
import ua.artcode.daojpa.DaoSubjectImplJPA;
import ua.artcode.model.modeljpa.Subject;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;


/**
 * Created by work on 19.11.2016.
 */

public class TestDAOSubject {

    private static DaoSubject daoSubject;
    private static EntityManagerFactory managerFactory;
    private static CreateDAO createDAO = null;
    private static InsertDAO insertDAO = null;
    private static DropDAO dropDAO = null;
    private static UpdateDAO updateDAO = null;


    @BeforeClass
    public static void connectManagerFactory(){
        createDAO = new CreateCommands();
        insertDAO = new InsertCommands();
        dropDAO = new DropCommands();
        updateDAO = new UpDateCommands();
        StartInitSQLDB.createTables(createDAO);
        StartInitSQLDB.initTables(insertDAO, updateDAO);
        managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        daoSubject = new DaoSubjectImplJPA(managerFactory);
    }

    @AfterClass
    public static void closeManagerFactory(){
        managerFactory.close();
        StartInitSQLDB.dropTables(dropDAO);
    }


    @Test
    public void testCreateDeleteSubject() {

        Subject subject = new Subject("Homosupiens", "Description Homosupiens");
        Subject subjectRes1 = (Subject) daoSubject.create(subject);
        boolean res2 = daoSubject.delete(subject);
        Assert.assertThat("Test method Create Delete Subject", true, equalTo((subjectRes1 != null) && res2));

    }

    @Test
    public void testGetAllSubject() {

        List<Subject> subjectList = daoSubject.getAllSubject();
        Assert.assertThat("Test method get All Subject", 60, equalTo(subjectList.size()));

    }


}

