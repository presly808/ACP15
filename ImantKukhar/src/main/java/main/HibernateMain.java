package main;

import hibernateDB.SubjectDao;
import hibernateModel.*;
import hibernateService.GroupService;
import hibernateService.StudentService;
import hibernateService.StudyService;
import hibernateService.SubjectService;
import utils.EntityManagerFactoryService;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Imant on 08.12.16.
 */
public class HibernateMain {
    public static void main(String[] args) {

//        Group group1 = new Group(2, "ACP_14");
//        Group group2 = new Group(7, "ACP_6");
//        Student student = new Student(3, "Roma", group1);
        Subject subject = new Subject("Fisika", "Qeens");
//        Teacher teacher = new Teacher(1, "Anna", 4, subject);
//        Study study = new Study(group1, subject);
////
//        GroupService groupService = new GroupService();
//        StudyService studyService = new StudyService();
//        studyService.addNewStudy(study);
        SubjectService subjectService = new SubjectService();
//        subjectService.addNewSubject(subject);


        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.persist(subject);
        transaction.commit();


//        System.out.println(groupService.getGroupsList(3, 2));
//        System.out.println(groupService.getGroupsListBySubject(subject).toString());

//        StudentService studentService = new StudentService();
//        System.out.println(studentService.getStudentsList(2, 0));
//        System.out.println(studentService.getStudentsListByGroup(group1));



    }
}
