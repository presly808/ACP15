package init;

import ua.artcode.dao.DaoGroup;
import ua.artcode.dao.DaoStudent;
import ua.artcode.dao.DaoSubject;
import ua.artcode.dao.DaoTeacher;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;
import ua.artcode.util.UtilsMethod;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by work on 13.11.2016.
 */
public class StartInitJPADB {

    private  static String[] studentNames = TestDataForDBSQL.generateStudentName();
    private  static String[] groups = TestDataForDBSQL.generateGroupName();
    private  static String[] teacherNames = init.TestDataForDBSQL.generateTeacherName();
    private  static String[] subjects = init.TestDataForDBSQL.generateSubjectName();

    public static void initTables (DaoGroup daoGroup, DaoSubject daoSubject, DaoTeacher daoTeacher, DaoStudent daoStudent, EntityManagerFactory managerFactory) {

        // Добавляем преподователей, предметы, группы и студентов
        addTeachersAndSubjects(daoTeacher);
        addGroupsWithListSubjects(daoGroup, daoSubject, managerFactory);
        addStudents(daoStudent);

        //Добавляем студента к группе
        addStudentToGroup(daoStudent);

    }

    private static void addGroupsWithListSubjects(DaoGroup daoGroup, DaoSubject daoSubject, EntityManagerFactory managerFactory) {

        List[] arraylists = new List[10];
        for (int i = 0; i < 10; i++) {
            List<Subject> subjectList = new ArrayList<>();
            arraylists[i] = subjectList;
        }

        for (int i = 5; i < 20; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[0].add(subject);
        }

        for (int i = 10; i < 20; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[1].add(subject);

        }

        List<Subject> subjectList3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[2].add(subject);
        }

        for (int i = 4; i < 18; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[3].add(subject);
        }

        for (int i = 6; i < 20; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[4].add(subject);
        }

        for (int i = 8; i < 19; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[5].add(subject);
        }

        for (int i = 1; i < 16; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[6].add(subject);
        }

        for (int i = 3; i < 12; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);;
            arraylists[7].add(subject);
        }

        for (int i = 2; i < 17; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[8].add(subject);
        }

        for (int i = 0; i < 20; i++) {
            int id = UtilsMethod.getIdOfSubject(subjects[i], managerFactory);
            Subject subject = (Subject) daoSubject.findById(id);
            arraylists[9].add(subject);
        }


        String [] groups = TestDataForDBSQL.generateGroupName();
        for (int i = 0; i < 10; i++) {
            Group group = new Group(groups[i]);
            group.setSubjectList(arraylists[i]);
            daoGroup.create(group);
        }
    }

    private static void addStudents(DaoStudent daoStudent) {
        String[] studentNames = TestDataForDBSQL.generateStudentName();
        for (int i = 0; i < 60; i++) {
            daoStudent.create(new Student(studentNames[i]));
        }
    }

    private static void addTeachersAndSubjects(DaoTeacher daoTeacher) {

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

    private static void addStudentToGroup(DaoStudent daoStudent) {

        for (int i = 0; i < studentNames.length; i++) {
            if (i < 6){
                daoStudent.updateByGroup(studentNames[i], groups[0]);
            } else if (i > 5 && i < 12){
                daoStudent.updateByGroup(studentNames[i], groups[1]);
            } else if (i > 11 && i < 18){
                daoStudent.updateByGroup(studentNames[i], groups[2]);
            } else if (i > 17 && i < 24){
                daoStudent.updateByGroup(studentNames[i], groups[3]);
            } else if (i > 23 && i < 30){
                daoStudent.updateByGroup(studentNames[i], groups[4]);
            } else if (i > 29 && i < 36){
                daoStudent.updateByGroup(studentNames[i], groups[5]);
            } else if (i > 35 && i < 42){
                daoStudent.updateByGroup(studentNames[i], groups[6]);
            } else if (i > 41 && i < 48){
                daoStudent.updateByGroup(studentNames[i], groups[7]);
            } else if (i > 47 && i < 54){
                daoStudent.updateByGroup(studentNames[i], groups[8]);
            } else if (i > 53 && i < 60){
                daoStudent.updateByGroup(studentNames[i], groups[9]);
            }
        }
    }


}
