package service;

import db.StudentDao;
import db.UniversityDao;
import model.Group;
import model.Student;

import java.util.List;

/**
 * Created by Imant on 28.11.16.
 */
public class StudentService {

    private StudentDao studentDao = StudentDao.getInstance();

    public boolean addNewStudent(Student student) {
        return studentDao.addNewStudent(student);
    }

    public boolean deleteStudent(Student student) {
        return studentDao.deleteStudent(student);
    }

    public Student getStudent(Student student) {
        return studentDao.getStudent(student);
    }

    public boolean editStudent(Student studentWithNewInfo) {
        return studentDao.editStudent(studentWithNewInfo);
    }

    public List<Student> getStudentsList(int limit, int offset) {
        return studentDao.getStudentsList(limit, offset);
    }

    public List<Student> getStudentsListByGroup(Group group) {
        return studentDao.getStudentsListByGroup(group);
    }
}
