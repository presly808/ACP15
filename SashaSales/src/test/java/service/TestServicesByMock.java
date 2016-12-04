package service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ua.artcode.daoSQL.interfaces.*;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.modelsql.Group;
import ua.artcode.model.modelsql.Student;
import ua.artcode.service.IService;
import ua.artcode.service.IServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import static org.hamcrest.Matchers.not;

/**
 * Created by work on 23.11.2016.
 */

public class TestServicesByMock {

    @Test
    public void testServiceGetGroups() {

        SelectDAO selectDAO = Mockito.mock(SelectDAO.class);
        Mockito.when(selectDAO.getGroups()).thenReturn(Arrays.asList(new Group(1, "APC11"), new Group(2, "APC12"), new Group(3, "APC13")));

        IService service = new IServiceImpl(selectDAO);
        List<Group> groupList = service.getAllGroups();

        Assert.assertEquals("Test service get Groups", 3, groupList.size());

        DeleteDAO deleteDAO = Mockito.mock(DeleteDAO.class);
        InsertDAO insertDAO = Mockito.mock(InsertDAO.class);
        UpdateDAO updateDAO = Mockito.mock(UpdateDAO.class);
        Mockito.when(selectDAO.getStudents()).thenReturn(Arrays.asList(new Student(1, "Ivan"), new Student(2, "Petr")));

    }

    @Test
    public void testServiceGetStudents() {

        SelectDAO selectDAO = Mockito.mock(SelectDAO.class);
        Mockito.when(selectDAO.getStudents()).thenReturn(Arrays.asList(new Student(1, "Ivan"), new Student(2, "Petr")));

        IService service = new IServiceImpl(selectDAO);
        List<Student> studentList = service.getAllStudents();
        Assert.assertEquals("Test service get Groups", 2, studentList.size());

    }

    @Test
    public void testServiceGetStudentsByGroup() throws EmptyException {

        SelectDAO selectDAO = Mockito.mock(SelectDAO.class);
        Mockito.when(selectDAO.getStudentsByGroup("ACO11")).thenReturn(Arrays.asList(new Student(1, "Ivan")));

        IService service = new IServiceImpl(selectDAO);
        List<Student> studentList = service.getAllStudentsByGroup("ACO11");
            Assert.assertEquals("Test service get Groups", 1, studentList.size());


    }

    @Test(expected = EmptyException.class)
    public void testServiceNegativeGetStudentsByGroup() throws EmptyException {

        SelectDAO selectDAO = Mockito.mock(SelectDAO.class);

        IService service = new IServiceImpl(selectDAO);
        List<Student> studentList = service.getAllStudentsByGroup("");
    }

    @Test(expected = EmptyException.class)
    public void testNegativeAddStudent() throws EmptyException {

        InsertDAO insertDAO = Mockito.mock(InsertDAO.class);
        IService iService = new IServiceImpl(insertDAO);
        iService.addStudent("");

    }

    @Test
    public void testAddStudent() {

        InsertDAO insertDAO = Mockito.mock(InsertDAO.class);
        Mockito.when(insertDAO.addStudent("Serhii")).thenReturn(true);
        IService iService = new IServiceImpl(insertDAO);

        boolean res = false;
        try {
            res = iService.addStudent("Serhii");
        } catch (EmptyException e) {
            res = false;
        }
        Assert.assertThat("Test Service method Add Student", res, not(false));

    }

}
