package service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ua.artcode.daoSQL.interfaces.*;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.service.IService;
import ua.artcode.service.IServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by work on 23.11.2016.
 */
public class TestMockito {

    @Test
    public void testServiceGetGroups() {

        SelectDAO selectDAO = Mockito.mock(SelectDAO.class);
        Mockito.when(selectDAO.getGroups()).thenReturn(Arrays.asList(new Group(1, "APC11"), new Group(2, "APC12"), new Group(3, "APC13")));

        IService service = new IServiceImpl(selectDAO);
        List<Group> groupList = service.getAllGroups();

        Assert.assertEquals("Test service get Groups", 3, groupList.size());

       /* DeleteDAO deleteDAO = Mockito.mock(DeleteDAO.class);
        InsertDAO insertDAO = Mockito.mock(InsertDAO.class);
        UpdateDAO updateDAO = Mockito.mock(UpdateDAO.class);
        Mockito.when(selectDAO.getStudents()).thenReturn(Arrays.asList(new Student(1, "Ivan"), new Student(2, "Petr")));*/
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
    public void testServiceGetStudentsByGroup() {

        SelectDAO selectDAO = Mockito.mock(SelectDAO.class);
        Mockito.when(selectDAO.getStudentsByGroup("ACO11")).thenReturn(Arrays.asList(new Student(1, "Ivan")));

        IService service = new IServiceImpl(selectDAO);
        List<Student> studentList = null;
        try {
            studentList = service.getAllStudentsByGroup("ACO11");
        } catch (EmptyException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Test service get Groups", 1, studentList.size());

    }

    @Test(expected = EmptyException.class)
    public void testServiceNegativeGetStudentsByGroup() throws EmptyException {

        SelectDAO selectDAO = Mockito.mock(SelectDAO.class);

        IService service = new IServiceImpl(selectDAO);
        List<Student> studentList = null;

        studentList = service.getAllStudentsByGroup("");
    }

    @Test
    public void testNegativeAddStudent() {

        InsertDAO insertDAO = Mockito.mock(InsertDAO.class);
        IService iService = new IServiceImpl(insertDAO);
        boolean res = true;
        try {
            iService.addStudent("");
        } catch (EmptyException e) {
            res = false;
        }
        Assert.assertEquals(false, res);

    }

    @Test
    public void testAddStudent() {

        InsertDAO insertDAO = Mockito.mock(InsertDAO.class);
        Mockito.when(insertDAO.addStudent("Serhii")).thenReturn(true);
        IService iService = new IServiceImpl(insertDAO);

        boolean res = false;
        try {
            res = iService.addStudent("Sergii");
        } catch (EmptyException e) {
            res = false;
        }
        Assert.assertEquals(true, res);

    }

}
