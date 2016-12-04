package init;

import org.springframework.beans.factory.annotation.Autowired;
import ua.artcode.dao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by work on 04.12.2016.
 */
public class RunInit {

    private static EntityManagerFactory managerFactory;
    private static DaoSubject daoSubject;
    private static DaoGroup daoGroup;
    private static DaoTeacher daoTeacher;
    private static DaoStudent daoStudent;

    public static void main(String[] args) {

        managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");

        DaoSubject daoSubject = new DaoSubjectImplJPA(managerFactory);
        DaoGroup daoGroup = new DaoGroupImplJPA(managerFactory);
        DaoTeacher daoTeacher = new DaoTeacherImplJPA(managerFactory);
        DaoStudent daoStudent = new DaoStudentImplJPA(managerFactory);

        StartInitJPADB.initTables(daoGroup, daoSubject, daoTeacher, daoStudent, managerFactory);
        managerFactory.close();

    }

}
