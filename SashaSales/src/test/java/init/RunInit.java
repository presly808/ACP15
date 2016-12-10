package init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.dao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by work on 04.12.2016.
 */
public class RunInit {



    public static void main(String[] args) {

        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:app-test-context.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:app-test-context.xml");

        EntityManagerFactory managerFactory = ctx.getBean(EntityManagerFactory.class);
        DaoSubject daoSubject = ctx.getBean(DaoSubject.class);
        DaoGroup daoGroup = ctx.getBean(DaoGroup.class);
        DaoTeacher daoTeacher = ctx.getBean(DaoTeacher.class);
        DaoStudent daoStudent = ctx.getBean(DaoStudent.class);

        StartInitJPADB.initTables(daoGroup, daoSubject, daoTeacher, daoStudent, managerFactory);
        managerFactory.close();

    }

}
