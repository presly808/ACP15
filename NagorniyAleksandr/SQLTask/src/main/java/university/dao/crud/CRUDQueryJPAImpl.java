package university.dao.crud;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import university.exceptions.AppDBException;
import university.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class CRUDQueryJPAImpl implements CRUDQuery {

    @PersistenceContext
    private EntityManager manager;

    public CRUDQueryJPAImpl() {
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    @Override

    public boolean addStudent(Student student) throws AppDBException {
        manager.persist(student);
        return true;
    }

    @Override
    public boolean addGroup(Group group) throws AppDBException {

        manager.persist(group);
        return true;
    }

    @Override
    public boolean addSubject(Subject subject) throws AppDBException {

        manager.persist(subject);
        return true;
    }

    @Override
    public boolean addSubjectCategory(SubjectCategory subjectCategory) throws AppDBException {

        manager.persist(subjectCategory);
        return true;
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws AppDBException {
        manager.persist(teacher);
        return true;

    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws AppDBException {
        Student tempStudent = manager.find(Student.class, studentWithNewData.getId());
        if (tempStudent == null) {
            String errorMessage = "Subject category not found";
            throw new AppDBException(errorMessage);
        }

        manager.merge(studentWithNewData);
        return true;
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws AppDBException {
        Group tempGroup = manager.find(Group.class, groupWithNewData.getId());
        if (tempGroup == null) {
            String errorMessage = "Subject category not found";
            throw new AppDBException(errorMessage);
        }

        manager.merge(groupWithNewData);
        return true;
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws AppDBException {
        Teacher tempTeacher = manager.find(Teacher.class, teacherWithNewData.getId());
        if (tempTeacher == null) {
            String errorMessage = "Subject category not found";
            throw new AppDBException(errorMessage);
        }

        manager.merge(teacherWithNewData);
        return true;
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws AppDBException {
        Subject tempSubject = manager.find(Subject.class, subjectWithNewData.getId());
        if (tempSubject == null) {
            String errorMessage = "Subject category not found";
            throw new AppDBException(errorMessage);
        }

        manager.merge(subjectWithNewData);
        return true;
    }

    @Override
    public boolean editSubjectCategory(SubjectCategory subjectCategoryWithNewData) throws AppDBException {
        SubjectCategory tempSubjectCategory = manager.find(SubjectCategory.class, subjectCategoryWithNewData.getId());
        if (tempSubjectCategory == null) {
            String errorMessage = "Subject category not found";
            throw new AppDBException(errorMessage);
        }

        manager.merge(subjectCategoryWithNewData);
        return true;
    }

    @Override
    public boolean deleteStudent(Student student) throws AppDBException {

        Student tempStudent = manager.find(Student.class, student.getId());
        if (tempStudent == null) {
            String errorMessage = "Student not found";
            throw new AppDBException(errorMessage);
        }

        manager.remove(tempStudent);
        return true;
    }

    @Override
    public boolean deleteGroup(Group group) throws AppDBException {

        Group tempGroup = manager.find(Group.class, group.getId());
        if (tempGroup == null) {
            String errorMessage = "Group not found";
            throw new AppDBException(errorMessage);
        }

        manager.remove(tempGroup);
        return true;
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) throws AppDBException {

        Teacher tempTeacher = manager.find(Teacher.class, teacher.getId());
        if (tempTeacher == null) {
            String errorMessage = "Subject not found";
            throw new AppDBException(errorMessage);
        }

        manager.remove(tempTeacher);
        return true;
    }

    @Override
    public boolean deleteSubject(Subject subject) throws AppDBException {

        Subject tempSubject = manager.find(Subject.class, subject.getId());
        if (tempSubject == null) {
            String errorMessage = "Subject not found";
            throw new AppDBException(errorMessage);
        }

        manager.remove(tempSubject);
        return true;
    }

    @Override
    public boolean deleteSubjectCategory(SubjectCategory subjectCategory) throws AppDBException {

        SubjectCategory tempSubjectCategory = manager.find(SubjectCategory.class, subjectCategory.getId());
        if (tempSubjectCategory == null) {
            String errorMessage = "Subject category not found";
            throw new AppDBException(errorMessage);
        }

        manager.remove(tempSubjectCategory);
        return true;
    }

    @Override
    public Student getStudent(Student student) throws AppDBException {

        Student foundedStudent = manager.find(Student.class, student.getId());
        if (foundedStudent != null) {
            return foundedStudent;
        } else {
            String errorMessage = "Student not found";
            throw new AppDBException(errorMessage);
        }
    }

    @Override
    public Group getGroup(Group group) throws AppDBException {

        Group foundedGroup = manager.find(Group.class, group.getId());
        if (foundedGroup != null) {

            return foundedGroup;
        } else {
            String errorMessage = "Group not found";
            throw new AppDBException(errorMessage);
        }
    }

    @Override
    public Teacher getTeacher(Teacher teacher) throws AppDBException {

        Teacher foundedTeacher = manager.find(Teacher.class, teacher.getId());
        if (foundedTeacher != null) {
            return foundedTeacher;
        } else {
            String errorMessage = "Teacher not found";
            throw new AppDBException(errorMessage);
        }
    }

    @Override
    public Subject getSubject(Subject subject) throws AppDBException {


        Subject foundedSubject = manager.find(Subject.class, subject.getId());
        if (foundedSubject != null) {

            return foundedSubject;
        } else {

            String errorMessage = "Subject not found";
            throw new AppDBException(errorMessage);
        }
    }

    @Override
    public SubjectCategory getSubjectCategory(SubjectCategory subjectCategory) throws AppDBException {

        SubjectCategory foundedSubjectCategory = manager.find(SubjectCategory.class, subjectCategory.getId());
        if (foundedSubjectCategory != null) {

            return foundedSubjectCategory;
        } else {

            String errorMessage = "Subject category not found";

            throw new AppDBException(errorMessage);
        }
    }
}
