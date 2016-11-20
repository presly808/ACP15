package init;

import ua.artcode.daoSQL.implementations.SelectCommands;
import ua.artcode.daoSQL.interfaces.*;
import ua.artcode.model.Subject;
import ua.artcode.util.PropertiesHolder;

import java.lang.reflect.Array;

/**
 * Created by work on 13.11.2016.
 */
public class StartInitDB {

    public static void createTables (CreateDAO createDAO) {

        createDAO.createTableGroups();
        createDAO.createTableSubject();
        createDAO.createTableTeachers();
        createDAO.createTableStudents();
        createDAO.createTableStudy();

    }

    public static void initTables (InsertDAO insertDAO, UpdateDAO updateDAO) {

        String [] groups = TestDataForDBSQL.generateGroupName();
        for (int i = 0; i < 10; i++) {
            insertDAO.addGroup(groups[i]);
        }

        System.out.println("init groups");

        String[] subjects = init.TestDataForDBSQL.generateSubjectName();
        for (int i = 0; i < 20; i++) {
            insertDAO.addSubject(subjects[i], "Description " + subjects[i]);
        }


        String[] teacherNames = init.TestDataForDBSQL.generateTeacherName();
        for (int i = 0; i < 20; i++) {
            if (i < 6) {
                insertDAO.addTeacher(teacherNames[i], 2, i+1);
            } else if (i > 5 && i < 12){
                insertDAO.addTeacher(teacherNames[i], i, i+1);
            } else if (i > 11 && i < 20){
                insertDAO.addTeacher(teacherNames[i], 1, i+1);
            }

        }

        String[] studentNames = init.TestDataForDBSQL.generateStudentName();
        for (int i = 0; i < 60; i++) {
            insertDAO.addStudent(studentNames[i]);
        }


        for (int i = 0; i < 60; i++) {
            if (i < 6){
                updateDAO.updateStudentByGroup(i+1, 1);
            } else if (i > 5 && i < 12){
                updateDAO.updateStudentByGroup(i+1, 2);
            } else if (i > 11 && i < 18){
                updateDAO.updateStudentByGroup(i+1, 3);
            } else if (i > 17 && i < 24){
                updateDAO.updateStudentByGroup(i+1, 4);
            } else if (i > 23 && i < 30){
                updateDAO.updateStudentByGroup(i+1, 5);
            } else if (i > 29 && i < 36){
                updateDAO.updateStudentByGroup(i+1, 6);
            } else if (i > 35 && i < 42){
                updateDAO.updateStudentByGroup(i+1, 7);
            } else if (i > 41 && i < 48){
                updateDAO.updateStudentByGroup(i+1, 8);
            } else if (i > 47 && i < 54){
                updateDAO.updateStudentByGroup(i+1, 9);
            } else if (i > 53 && i < 60){
                updateDAO.updateStudentByGroup(i+1, 10);
            }

        }

    }

    public static void initTableStudy (InsertDAO insertDAO) {



    }

    public static void dropTables (DropDAO dropDAO) {

        dropDAO.dropTableStudy();
        dropDAO.dropTableStudents();
        dropDAO.dropTableTeachers();
        dropDAO.dropTableSubjects();
        dropDAO.dropTableGroups();
    }

}
