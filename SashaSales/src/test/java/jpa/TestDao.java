package jpa;

import init.StartInitJPADB;
import ua.artcode.daojpa.*;
import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Subject;
import ua.artcode.model.modeljpa.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public class TestDao {


    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        DaoGroup<Group> daoGroup = new DaoGroupImplJPA(managerFactory);
        DaoSubject<Subject> daoSubject = new DaoSubjectImplJPA(managerFactory);
        DaoTeacher<Teacher> daoTeacher = new DaoTeacherImplJPA(managerFactory);

        Subject subject = new Subject("HomosupiensFree", "Description Homosupiens");
        Subject subject1 = new Subject("HomosupiensFree1", "Description Homosupiens");
        Subject subject2 = new Subject("HomosupiensFree2", "Description Homosupiens");
        System.out.println(subject.getId());
        System.out.println(subject1.getId());
        System.out.println(subject2.getId());

/*        StartInitJPADB.initTables(daoGroup, managerFactory);
        List<Teacher> groupList = daoTeacher.getAllTeacher();
        System.out.println(groupList.size());
        groupList.forEach(System.out::print);*/

        /*Subject subject = new Subject("HomosupiensFree", "Description Homosupiens");
        Teacher teacher = new Teacher("Timur", 2, subject);

        try {
            entityTransaction.begin();
            entityManager.persist(subject);
            entityManager.persist(teacher);
            entityTransaction.commit();
        } catch (Exception e){
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }*/


  /*      List<Group> groupList = daoGroup.getAllGroup();
        System.out.println(groupList.size());
        groupList.forEach(System.out::print);*/
        managerFactory.close();

    }

}
