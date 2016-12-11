package service;

import db.StudyDao;
import db.UniversityDao;
import model.Student;
import model.Study;

/**
 * Created by Imant on 28.11.16.
 */
public class StudyService {

    private StudyDao studyDao = StudyDao.getInstance();

    public boolean addNewStudy(Study study) {
        return studyDao.addNewStudy(study);
    }

    public boolean deleteStudent(Study study) {
        return studyDao.deleteStudy(study);
    }

//    public Student getStudent(Study study) {
//    }
//
//    public boolean editStudy(Study studyWithNewInfo) {
//    }
}
