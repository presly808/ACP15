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
        createDAO.createTableMarks();

    }

    public static void dropTables (DropDAO dropDAO) {

        dropDAO.dropTableStudy();
        dropDAO.dropTableStudents();
        dropDAO.dropTableTeachers();
        dropDAO.dropTableSubjects();
        dropDAO.dropTableGroups();
        dropDAO.dropTableMarks();
    }

    public static void initTables (InsertDAO insertDAO, UpdateDAO updateDAO) {

        // Добавляем группы
        addGroups(insertDAO);

        // Добавляем предметы
        addSubjects(insertDAO);

        // Добавляем преподователей
        addTeachers(insertDAO);

        // Добавляем студентов
        addStudents(insertDAO);

        //Добавляем студента к группе
        addStudentToGroup(updateDAO);

        //Заполняем таблицу study
        initStudy(insertDAO);

    }


    private static void addGroups(InsertDAO insertDAO) {
        String [] groups = TestDataForDBSQL.generateGroupName();
        for (int i = 0; i < 10; i++) {
            insertDAO.addGroup(groups[i]);
        }
    }

    private static void addSubjects(InsertDAO insertDAO) {
        String[] subjects = TestDataForDBSQL.generateSubjectName();
        for (int i = 0; i < 20; i++) {
            insertDAO.addSubject(subjects[i], "Description " + subjects[i]);
        }
    }

    private static void addStudents(InsertDAO insertDAO) {
        String[] studentNames = TestDataForDBSQL.generateStudentName();
        for (int i = 0; i < 60; i++) {
            insertDAO.addStudent(studentNames[i]);
        }
    }

    private static void addTeachers(InsertDAO insertDAO) {
        String[] teacherNames = TestDataForDBSQL.generateTeacherName();
        for (int i = 0; i < 20; i++) {
            if (i < 6) {
                insertDAO.addTeacher(teacherNames[i], 2, i+1);
            } else if (i > 5 && i < 12){
                insertDAO.addTeacher(teacherNames[i], i, i+1);
            } else if (i > 11 && i < 20){
                insertDAO.addTeacher(teacherNames[i], 1, i+1);
            }

        }
    }

    private static void addStudentToGroup(UpdateDAO updateDAO) {
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

    private static void initStudy(InsertDAO insertDAO) {

        for (int i = 5; i < 20; i++) {
            insertDAO.addFieldStudy(1, i+1);
            for (int j = 0; j < 6; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 10; i < 20; i++) {
            insertDAO.addFieldStudy(2, i+1);
            for (int j = 6; j < 12; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 0; i < 10; i++) {
            insertDAO.addFieldStudy(3, i+1);
            for (int j = 12; j < 18; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 4; i < 18; i++) {
            insertDAO.addFieldStudy(4, i+1);
            for (int j = 18; j < 24; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 6; i < 20; i++) {
            insertDAO.addFieldStudy(5, i+1);
            for (int j = 24; j < 30; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 8; i < 19; i++) {
            insertDAO.addFieldStudy(6, i+1);
            for (int j = 30; j < 36; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 1; i < 16; i++) {
            insertDAO.addFieldStudy(6, i+1);
            for (int j = 36; j < 42; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 3; i < 12; i++) {
            insertDAO.addFieldStudy(8, i+1);
            for (int j = 42; j < 48; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 2; i < 17; i++) {
            insertDAO.addFieldStudy(9, i+1);
            for (int j = 48; j < 54; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }

        for (int i = 0; i < 20; i++) {
            insertDAO.addFieldStudy(10, i+1);
            for (int j = 54; j < 60; j++) {
                insertDAO.addFieldMark(j+1, i+1, (int) (10*Math.random()));
            }
        }
    }


}
