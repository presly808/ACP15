package init;

import ua.artcode.daoSQL.interfaces.InsertDAO;
import ua.artcode.daojpa.DaoGroup;
import ua.artcode.daojpa.DaoStudent;
import ua.artcode.daojpa.DaoTeacher;
import ua.artcode.model.modeljpa.Group;
import ua.artcode.model.modeljpa.Student;
import ua.artcode.model.modeljpa.Subject;
import ua.artcode.model.modeljpa.Teacher;

/**
 * Created by work on 13.11.2016.
 */
public class StartInitJPADB {

    public static void initTables (DaoTeacher daoTeacher, DaoStudent daoStudent) {

        // Добавляем преподователей и предметы
        addTeachersAndSubjects(daoTeacher);

        // Добавляем группы
      //  addStudentsAndGroups(daoStudent);


  /*      //Добавляем студента к группе
        addStudentToGroup(updateDAO);

        //Заполняем таблицу study
        initStudy(insertDAO);*/

    }


    private static void addTeachersAndSubjects(DaoTeacher daoTeacher) {
        String[] teacherNames = init.TestDataForDBSQL.generateTeacherName();
        String[] subjects = init.TestDataForDBSQL.generateSubjectName();
        for (int i = 0; i < 20; i++) {
            if (i < 6) {
                Subject subject = new Subject(subjects[i], "Description " + subjects[i]);
                Teacher teacher = new Teacher(teacherNames[i], 2, subject);
                daoTeacher.create(teacher);
            } else if (i > 5 && i < 12){
                Subject subject = new Subject(subjects[i], "Description " + subjects[i]);
                Teacher teacher = new Teacher(teacherNames[i], i, subject);
                daoTeacher.create(teacher);
            } else if (i > 11 && i < 20){
                Subject subject = new Subject(subjects[i], "Description " + subjects[i]);
                Teacher teacher = new Teacher(teacherNames[i], 1, subject);
                daoTeacher.create(teacher);
            }

        }
    }

    private static void addStudentsAndGroups(DaoStudent daoStudent) {

        String[] studentNames = init.TestDataForDBSQL.generateStudentName();
        String [] groups = init.TestDataForDBSQL.generateGroupName();
        for (int i = 0; i < 60; i++) {
            if (i < 6){
                Group group = new Group(groups[0]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 5 && i < 12){
                Group group = new Group(groups[1]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 11 && i < 18){
                Group group = new Group(groups[2]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 17 && i < 24){
                Group group = new Group(groups[3]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 23 && i < 30){
                Group group = new Group(groups[4]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 29 && i < 36){
                Group group = new Group(groups[5]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 35 && i < 42){
                Group group = new Group(groups[6]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 41 && i < 48){
                Group group = new Group(groups[7]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 47 && i < 54){
                Group group = new Group(groups[8]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
            } else if (i > 53 && i < 60){
                Group group = new Group(groups[9]);
                Student student = new Student(studentNames[i], group);
                daoStudent.create(student);
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
