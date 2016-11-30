package jpa;

import init.StartInitJPADB;
import ua.artcode.daojpa.*;
import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;
import ua.artcode.model.modeljpa.Subject;
import ua.artcode.model.modeljpa.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public class TestDao {


    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        DaoTeacher<Teacher> daoTeacher = new DaoTeacherImplJPA(managerFactory);
        DaoStudent<Student> daoStudent = new DaoStudentImplJPA(managerFactory);
        DaoGroup<Group> daoGroup = new DaoGroupImplJPA(managerFactory);
        DaoSubject<Subject> daoSubject = new DaoSubjectImplJPA(managerFactory);

        //StartInitJPADB.initTables(daoGroup, daoSubject, daoTeacher, daoStudent, managerFactory);

        List<Group> groupList = daoGroup.getGroupsThatStudySubject("Base16");
        groupList.forEach(System.out::print);

       /* EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Subject subject = new Subject("HomosupiensFree", "Description Homosupiens");
        daoSubject.create(subject);
        Subject subject1 = new Subject("HomosupiensFree1", "Description Homosupiens1");
        daoSubject.create(subject1);
        Subject subject2 = new Subject("HomosupiensFree2", "Description Homosupiens2");
        daoSubject.create(subject2);
        Subject subject3 = new Subject("HomosupiensFree3", "Description Homosupiens3");
        daoSubject.create(subject3);

        List<Subject> subjectList1 = new ArrayList<>();
        subjectList1.add(subject);
        subjectList1.add(subject2);
        subjectList1.add(subject1);

        List<Subject> subjectList2 = new ArrayList<>();
        subjectList2.add(subject1);
        subjectList2.add(subject2);
        subjectList2.add(subject3);


       // Teacher teacher = new Teacher("Timur", 2, subject);
        Group group = new Group("Base16");
        group.setSubjectList(subjectList1);
        daoGroup.create(group);
        Group group1 = new Group("Base17");
        group1.setSubjectList(subjectList2);
        daoGroup.create(group1);
*/



      //  Student student = new Student("Ivan", group);


/*
        try {
            entityTransaction.begin();
            entityManager.persist(subject);
            entityManager.persist(teacher);
            entityManager.persist(group);
            entityManager.persist(student);
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
