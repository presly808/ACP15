package main;

import hibernateModel.*;
import hibernateService.GroupService;
import utils.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Created by Imant on 08.12.16.
 */
public class HibernateMain {
    public static void main(String[] args) {

        Group group1 = new Group(2, "ACP_14");
        Group group2 = new Group(7, "ACP_6");
        Student student = new Student(3, "Roma", group1);
        Subject subject = new Subject(1, "Math", "Qeen");
        Teacher teacher = new Teacher(1, "Anna", 4, subject);
        Study study = new Study(2, group1, subject);

        GroupService groupService = new GroupService();
////        groupService.addNewGroup(group1);
////        groupService.deleteGroup(group2);
//        groupService.getGroup(group1);
//        System.out.println(groupService.getGroup(group1).toString());
        System.out.println(groupService.getGroupsList(3, 2));
    }
}
