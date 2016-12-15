package hibernateService;

import hibernateDB.StudyDao;
import hibernateModel.Study;

/**
 * Created by Imant on 28.11.16.
 */
public class StudyService {

    private StudyDao studyDao = StudyDao.getInstance();

    public boolean addNewStudy(Study study) {
        return studyDao.addNewStudy(study);
    }

    public boolean deleteStudy(Study study) {
        return studyDao.deleteStudy(study);
    }

    public Study getStudy(Study study) {
        return studyDao.getStudy(study);
    }

    public boolean editStudy(Study studyWithNewInfo) {
        return studyDao.editStudy(studyWithNewInfo);
    }
}
