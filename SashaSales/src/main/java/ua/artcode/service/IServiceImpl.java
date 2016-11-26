package ua.artcode.service;

import org.apache.log4j.Logger;
import ua.artcode.daoSQL.implementations.*;
import ua.artcode.daoSQL.interfaces.DeleteDAO;
import ua.artcode.daoSQL.interfaces.InsertDAO;
import ua.artcode.daoSQL.interfaces.SelectDAO;
import ua.artcode.daoSQL.interfaces.UpdateDAO;
import ua.artcode.exceptions.EmptyException;
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

    public IServiceImpl(SelectDAO selectDAO) {
        LOGGER.trace("Create IServiceImpl instance");
        this.selectDAO = selectDAO;
    }

    public IServiceImpl(InsertDAO insertDAO) {
        LOGGER.trace("Create IServiceImpl instance");
        this.insertDAO = insertDAO;

    }

    public IServiceImpl(SelectDAO selectDAO, DeleteDAO deleteDAO, UpdateDAO updateDAO, InsertDAO insertDAO) {
        LOGGER.trace("Create IServiceImpl instance");
        this.selectDAO = selectDAO;
        this.deleteDAO = deleteDAO;
        this.insertDAO = insertDAO;
        this.updateDAO = updateDAO;
    }


    @Override
    public List<Student> getAllStudents() {

        List<Student> students = null;

        students = selectDAO.getStudents();
        return students;
    }

    @Override
    public List<Student> getAllStudentsByGroup(String nameGroup) throws EmptyException {

        List<Student> students = null;
        if (nameGroup.isEmpty()){
            throw new EmptyException("group_name is empty");
        }
        students = selectDAO.getStudentsByGroup(nameGroup);
        return students;
    }

    @Override
    public List<Subject> getAllSubjects() {

        List<Subject> subjects = null;
        subjects = selectDAO.getSubjects();
        return subjects;
    }

    @Override
    public List<Teacher> getAllTeachers() {

        List<Teacher> teachers = null;
        teachers = selectDAO.getTeachers();
        return teachers;
    }

    @Override
    public List<Group> getAllGroups() {

        List<Group> groups = null;
        groups = selectDAO.getGroups();
        return groups;
    }

    @Override
    public boolean addStudent(String student_name) throws EmptyException {

        if (student_name.isEmpty()){
            throw new EmptyException("student_name is empty");
        }
        return insertDAO.addStudent(student_name);

    }

    @Override
    public boolean addSubject(String subject_name, String subjects_description) throws EmptyException {

        if (subject_name.isEmpty()){
            throw new EmptyException("subject_name is empty");
        }
        return insertDAO.addSubject(subject_name, subjects_description);
    }

    @Override
    public boolean addTeacher(String teacher_name, int experience, int subject_id) throws EmptyException {

        if (teacher_name.isEmpty()){
            throw new EmptyException("teacher_name is empty");
        }

        return insertDAO.addTeacher(teacher_name, experience, subject_id);

    }

    @Override
    public boolean addGroup(String group_name) throws EmptyException {

        if (group_name.isEmpty()){
            throw new EmptyException("group_name is empty");
        }
        return insertDAO.addGroup(group_name);
    }

    @Override
    public boolean deleteStudent(String student_name) throws EmptyException {

        if (student_name.isEmpty()){
            throw new EmptyException("student_name is empty");
        }
        return deleteDAO.deleteStudent(student_name);
    }

    @Override
    public boolean deleteSubject(String subject_name) throws EmptyException {

        if (subject_name.isEmpty()){
            throw new EmptyException("subject_name is empty");
        }
        return deleteDAO.deleteSubject(subject_name);
    }

    @Override
    public boolean deleteTeacher(String teacher_name) throws EmptyException {

        if (teacher_name.isEmpty()){
            throw new EmptyException("teacher_name is empty");
        }
        return deleteDAO.deleteTeacher(teacher_name);
    }

    @Override
    public boolean deleteGroup(String group_name) throws EmptyException {

        if (group_name.isEmpty()){
            throw new EmptyException("group_name is empty");
        }
        return deleteDAO.deleteGroup(group_name);
    }

    @Override
    public boolean upDateByGroup(int student_id, int group_id) {
        if (student_id <= 0){
            return false;
        }
        return updateDAO.updateStudentByGroup(student_id, group_id);
    }

    @Override
    public List<Group> getGroupsThatStudySubject(String subject_name) throws EmptyException {
        if (subject_name.isEmpty()){
            throw new EmptyException("group_name is empty");
        }

        return selectDAO.getGroupsThatStudySubject(subject_name);
    }

    @Override
    public List<Group> groupsThatStudyAllSubjects() {
        return null;
    }

    @Override
    public List<Teacher> getTeachersThatWorkMore3Years() {
        return selectDAO.getTeachersThatWorkMore3Years();
    }

    @Override
    public List<Subject> getAllGumanitarSubjects() {
        return null;
    }

    @Override
    public double avgMarkBySubjectInUniversity(String subject_name) throws EmptyException {

        if (subject_name.isEmpty()){
            throw new EmptyException("subject_name is empty");
        }
        return selectDAO.avgMarkBySubjectInUniversity(subject_name);
    }

    @Override
    public double avgMarkBySubjectInGroup(String subjectName, String groupName) throws EmptyException {

        if (subjectName.isEmpty() || groupName.isEmpty()){
            throw new EmptyException("subject_name is empty");
        }
        return selectDAO.avgMarkBySubjectInGroup(groupName, subjectName);
    }

    @Override
    public List<Group> groupsInThatMore3StudentsStudyphilosophy() {
        return null;
    }
}
