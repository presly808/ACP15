package service;

import db.SubjectDao;
import db.UniversityDao;
import model.Subject;

import java.util.List;

/**
 * Created by Imant on 28.11.16.
 */
public class SubjectService {

    private SubjectDao subjectDao = SubjectDao.getInstance();

    public boolean addNewSubject(Subject subject) {
        return subjectDao.addNewSubject(subject);
    }

    public boolean deleteSubject(Subject subject) {
        return subjectDao.deleteSubject(subject);
    }

    public Subject getSubject(Subject subject) {
        return subjectDao.getSubject(subject);
    }

    public boolean editSubject(Subject subjectWithNewInfo) {
        return subjectDao.editSubject(subjectWithNewInfo);
    }

    public List<Subject> getSubjectsList(int limit, int offset) {
        return subjectDao.getSubjectsList(limit, offset);
    }
}
