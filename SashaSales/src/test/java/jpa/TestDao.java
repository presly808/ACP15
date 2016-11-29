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
import java.util.List;

/**
 * Created by work on 27.11.2016.
 */
public class TestDao {


    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        DaoTeacher<Teacher> daoTeacher = new DaoTeacherImplJPA(managerFactory);
        DaoStudent<Student> daoStudent = new DaoStudentImplJPA(managerFactory);



        StartInitJPADB.initTables(daoTeacher, daoStudent);
        List<Teacher> groupList = daoTeacher.getAllTeacher();
        System.out.println(groupList.size());
        groupList.forEach(System.out::print);
        List<Student> studentList = daoStudent.getAllStudents();
        System.out.println(studentList.size());
        studentList.forEach(System.out::print);

/*        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Subject subject = new Subject("HomosupiensFree", "Description Homosupiens");
        Teacher teacher = new Teacher("Timur", 2, subject);
        Group group = new Group("Base16");
        Student student = new Student("Ivan", group);

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
