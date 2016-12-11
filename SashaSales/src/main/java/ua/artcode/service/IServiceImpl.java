
package ua.artcode.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ua.artcode.dao.DaoGroup;
import ua.artcode.dao.DaoStudent;
import ua.artcode.dao.DaoSubject;
import ua.artcode.dao.DaoTeacher;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;
import ua.artcode.util.UtilsMethod;

import javax.persistence.EntityManagerFactory;
import java.util.List;


/**
 * Created by work on 12.11.2016.
 */

@Service
public class IServiceImpl implements IService {

    private static final Logger LOGGER = Logger.getLogger(IServiceImpl.class);

    @Autowired
    private DaoGroup daoGroup;
    @Autowired
    private DaoStudent daoStudent;
    @Autowired
    private DaoSubject daoSubject;
    @Autowired
    private DaoTeacher daoTeacher;

    public IServiceImpl() {
    }

    public IServiceImpl(DaoGroup daoGroup, DaoStudent daoStudent, DaoSubject daoSubject, DaoTeacher daoTeacher) {
        LOGGER.trace("Create IServiceImpl instance");
        this.daoGroup = daoGroup;
        this.daoStudent = daoStudent;
        this.daoSubject = daoSubject;
        this.daoTeacher = daoTeacher;
    }


    @Override
    public List<Student> getAllStudents() {

        return daoStudent.getAll();
    }

   /* @Override
    public List<Student> getAllStudentsByGroup(String nameGroup) throws EmptyException {

        List<Student> students = null;
        if (nameGroup.isEmpty()){
            throw new EmptyException("group_name is empty");
        }
        students = selectDAO.getStudentsByGroup(nameGroup);
        return students;
    }*/

    @Override
    public List<Subject> getAllSubjects() {

        return daoSubject.getAll();
    }

    @Override
    public List<Teacher> getAllTeachers() {

        return daoTeacher.getAll();
    }

    @Override
    public List<Group> getAllGroups() {

        return daoGroup.getAll();
    }

    @Override
    public List<Group> getAllFirstFiveGroupsFromIndex(int index, int size) {

        return daoGroup.getFirstLimitResuliList(index, size);
    }

    @Override
    public Student addStudent(String student_name) throws EmptyException {

        if (student_name.isEmpty()){
            throw new EmptyException("student_name is empty");
        }

        return (Student) daoStudent.create(new Student(student_name));

    }

    @Override
    public Subject addSubject(String subject_name, String subjects_description) throws EmptyException {

        if (subject_name.isEmpty()) {
            throw new EmptyException("subject_name is empty");
        }
        return (Subject) daoSubject.create(new Subject(subject_name, subjects_description));
    }

    @Override
    public Teacher addTeacher(String teacher_name, int experience, int subject_id) throws EmptyException {

        if (teacher_name.isEmpty()){
            throw new EmptyException("teacher_name is empty");
        }

        Subject subject = (Subject) daoSubject.findById(subject_id);
        Teacher teacher = new Teacher(teacher_name, experience, subject);
        return (Teacher) daoTeacher.create(teacher);

    }

    @Override
    public Group addGroup(String group_name) throws EmptyException {

        if (group_name.isEmpty()){
            throw new EmptyException("group_name is empty");
        }

        daoGroup.create(new Group(group_name));


        return (Group) daoGroup.getEntityByName(group_name);
    }

    @Override
    public boolean deleteStudent(String student_name) throws EmptyException {

        if (student_name.isEmpty()){
            throw new EmptyException("student_name is empty");
        }
        return daoStudent.delete(student_name);
    }

    @Override
    public boolean deleteSubject(String subject_name) throws EmptyException {

        if (subject_name.isEmpty()){
            throw new EmptyException("subject_name is empty");
        }

        return daoSubject.delete(subject_name);
    }

    @Override
    public boolean deleteTeacher(String teacher_name) throws EmptyException {

        if (teacher_name.isEmpty()){
            throw new EmptyException("teacher_name is empty");
        }
        return daoTeacher.delete(teacher_name);
    }

    @Override
    public boolean deleteGroup(String group_name) throws EmptyException {

        if (group_name.isEmpty()){
            throw new EmptyException("group_name is empty");
        }
        return daoGroup.delete(group_name);
    }

    @Override
    public Student upDateByGroup(String student_name, String group_name) throws EmptyException {
        if (student_name.isEmpty() || group_name.isEmpty()){
            throw new EmptyException("group_name is empty");
        }
        return (Student) daoStudent.updateByGroup(student_name, group_name);
    }

    @Override
    public List<Group> getGroupsThatStudySubject(String subject_name) throws EmptyException {
        if (subject_name.isEmpty()){
            throw new EmptyException("group_name is empty");
        }

        return daoGroup.getGroupsThatStudySubject(subject_name);
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
    public double avgMarkBySubjectInUniversity(String subject_name) throws EmptyException {

        if (subject_name.isEmpty()){
            throw new EmptyException("subject_name is empty");
        }
        return 0.00;
    }

    @Override
    public double avgMarkBySubjectInGroup(String subjectName, String groupName) throws EmptyException {

        if (subjectName.isEmpty() || groupName.isEmpty()){
            throw new EmptyException("subject_name is empty");
        }
        return 0.00;
    }

    @Override
    public List<Group> groupsInThatMore3StudentsStudyphilosophy() {
        return null;
    }

}
