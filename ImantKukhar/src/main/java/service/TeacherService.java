package service;

import db.TeacherDao;
import model.Teacher;

import java.util.List;

/**
 * Created by Imant on 28.11.16.
 */
public class TeacherService {

    private TeacherDao teacherDao = TeacherDao.getInstance();

    public boolean addNewTeacher(Teacher teacher) {
        return teacherDao.addNewTeacher(teacher);
    }

    public boolean deleteTeacher(Teacher teacher) {
        return teacherDao.deleteTeacher(teacher);
    }

    public Teacher getTeacher(Teacher teacher) {
        return teacherDao.getTeacher(teacher);
    }

    public boolean editTeacher(Teacher teacherWithNewInfo) {
        return teacherDao.editTeacher(teacherWithNewInfo);
    }

    public List<Teacher> getTeachersList(int limit, int offset) {
        return teacherDao.getTeachersList(limit, offset);
    }
}
