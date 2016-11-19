package ua.artcode.service;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.implementations.*;
import ua.artcode.daoSQL.interfaces.DeleteDAO;
import ua.artcode.daoSQL.interfaces.InsertDAO;
import ua.artcode.daoSQL.interfaces.SelectDAO;
import ua.artcode.daoSQL.interfaces.UpdateDAO;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import java.util.List;

/**
 * Created by work on 12.11.2016.
 */
public class IServiceImpl implements IService {

    private static final Logger LOGGER = Logger.getLogger(IServiceImpl.class);

    private SelectDAO selectDAO;
    private DeleteDAO deleteDAO;
    private UpdateDAO updateDAO;
    private InsertDAO insertDAO;

    public IServiceImpl() {
        LOGGER.trace("Create IServiceImpl instance");
        this.selectDAO = new SelectCommands();
        this.deleteDAO = new DeleteCommands();
        this.insertDAO = new InsertCommands();
        this.updateDAO = new UpDateCommands();
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = null;

        try {
            students = selectDAO.getStudents();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> getAllStudentsByGroup(String nameGroup) {

        List<Student> students = null;

        try {
            students = selectDAO.getStudentsByGroup(nameGroup);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Subject> getAllSubjects() {

        List<Subject> subjects = null;

        try {
            subjects = selectDAO.getSubjects();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    @Override
    public List<Teacher> getAllTeachers() {


        List<Teacher> teachers = null;

        try {
            teachers = selectDAO.getTeachers();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public List<Group> getAllGroups() {


        List<Group> groups = null;

        try {
            groups = selectDAO.getGroups();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return groups;
    }

    @Override
    public boolean addStudent(String student_name) {
        try {
            return insertDAO.addStudent(student_name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addSubject(String subject_name, String subjects_description) {

        try {
            return insertDAO.addSubject(subject_name, subjects_description);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addTeacher(String teacher_name, int experience, int subject_id) {
        try {
            return insertDAO.addTeacher(teacher_name, experience, subject_id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addGroup(String group_name) {

        try {
            return insertDAO.addGroup(group_name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(String student_name) {
        try {
            return deleteDAO.deleteStudent(student_name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSubject(String subject_name) {
        try {
            return deleteDAO.deleteSubject(subject_name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTeacher(String teacher_name) {

        try {
            return deleteDAO.deleteTeacher(teacher_name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteGroup(String group_name) {
        try {
            return deleteDAO.deleteGroup(group_name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean upDateByGroup(int student_id, int group_id) {

        try {
            return updateDAO.updateStudentByGroup(student_id, group_id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Group> groupsThatStudySubject(Subject subject) {
        return null;
    }

    @Override
    public List<Group> groupsThatStudyAllSubjects() {
        return null;
    }

    @Override
    public List<Teacher> getTeachersThatWorkMore3Years() {
        return null;
    }

    @Override
    public List<Subject> getAllGumanitarSubjects() {
        return null;
    }

    @Override
    public int avgMarkBySubjectInUniversity(Subject subject) {
        return 0;
    }

    @Override
    public int avgMarkBySubjectInGroup(Subject subject, Group group) {
        return 0;
    }

    @Override
    public List<Group> groupsInThatMore3StudentsStudyphilosophy() {
        return null;
    }
}
