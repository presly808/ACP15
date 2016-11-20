package init;

import ua.artcode.daoSQL.implementations.SelectCommands;
import ua.artcode.daoSQL.interfaces.*;
import ua.artcode.model.Subject;
import ua.artcode.util.PropertiesHolder;

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

        /*for (int i = 0; i < 5; i++) {
            insertDAO.addGroup(init.TestDataForDBSQL.generateGroupName());
        }*/


        insertDAO.addGroup("Base11");
        insertDAO.addGroup("ACO11");
        insertDAO.addGroup("ACP11");
        insertDAO.addGroup("Base12");
        insertDAO.addGroup("ACO11");
        insertDAO.addGroup("ACP11");

        String[] subjects = init.TestDataForDBSQL.generateSubjectName();
        for (int i = 0; i < 10; i++) {
            insertDAO.addSubject(subjects[i], "Description " + subjects[i]);
        }

        for (int i = 0; i < 10; i++) {
            insertDAO.addTeacher(init.TestDataForDBSQL.generateName(), (int) (Math.random()*10), i+1);
        }

        for (int i = 0; i < 20; i++) {
            insertDAO.addStudent(init.TestDataForDBSQL.generateName());
        }


        for (int i = 0; i < 20; i++) {
            if (i < 8) {
                updateDAO.updateStudentByGroup(i, 1);
            } else if (i < 14) {
                updateDAO.updateStudentByGroup(i, 3);
            } else {
                updateDAO.updateStudentByGroup(i, 4);
            }
        }

    }

    public static void initTableStudy (InsertDAO insertDAO) {

        for (int i = 0; i < 5; i++) {
            insertDAO.addGroup(init.TestDataForDBSQL.generateGroupName());
        }

        String[] subjects = init.TestDataForDBSQL.generateSubjectName();
        for (int i = 0; i < 10; i++) {
            insertDAO.addSubject(subjects[i], "Description " + subjects[i]);
        }

        for (int i = 0; i < 10; i++) {
            insertDAO.addTeacher(init.TestDataForDBSQL.generateName(), (int) (Math.random()*10), i+1);
        }

        for (int i = 0; i < 20; i++) {
            insertDAO.addStudent(init.TestDataForDBSQL.generateName());
        }

    }

    public static void dropTables (DropDAO dropDAO) {

        dropDAO.dropTableStudy();
        dropDAO.dropTableStudents();
        dropDAO.dropTableTeachers();
        dropDAO.dropTableSubjects();
        dropDAO.dropTableGroups();
    }

}
