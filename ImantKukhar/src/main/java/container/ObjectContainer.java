package container;

import model.*;

/**
 * Created by Imant on 29.11.16.
 */
public class ObjectContainer {

    Group ACP1 = new Group(1, "ACP1");
    Group ACP2 = new Group(2, "ACP2");
    Group ACP3 = new Group(3, "ACP3");
    Group ACP4 = new Group(4, "ACP4");


    Student student1 = new Student(1, "Ivan", ACP1);
    Student student2 = new Student(2, "Andriy", ACP1);
    Student student3 = new Student(3, "Alex", ACP1);
    Student student4 = new Student(4, "Evgenii", ACP1);
    Student student5 = new Student(5, "Dima", ACP1);

    Student student6 = new Student(6, "Oleg", ACP2);
    Student student7 = new Student(7, "Ivan", ACP2);
    Student student8 = new Student(8, "Artem", ACP2);

    Student student9 = new Student(9, "Ira", ACP3);
    Student student10 = new Student(10, "Alex", ACP3);
    Student student11 = new Student(11, "Bogdan", ACP3);
    Student student12 = new Student(12, "Sergii", ACP3);

    Student student13 = new Student(13, "Anna", ACP4);
    Student student14 = new Student(14, "Ivan", ACP4);
    Student student15 = new Student(15, "Artyr", ACP4);
    Student student16 = new Student(16, "Igor", ACP4);


    Subject history = new Subject(1, "History", "History");
    Subject music = new Subject(2, "Music", "Music");
    Subject philosophy = new Subject(3, "Philosophy", "Philosophy");
    Subject literature = new Subject(4, "Literature", "Literature");
    Subject biology = new Subject(5, "Biology", "Biology");
    Subject chemistry = new Subject(6, "Chemistry", "Chemistry");
    Subject computerScience = new Subject(7, "Computer Science", "Computer Science");
    Subject physics = new Subject(8, "Physics", "Physics");
    Subject economics = new Subject(9, "Economics", "Economics");
    Subject mathematics = new Subject(10, "Mathematics", "Mathematics");


    Teacher teacher1 = new Teacher(1, "Victoria", 3, history);
    Teacher teacher2 = new Teacher(2, "Inna", 3, music);
    Teacher teacher3 = new Teacher(1, "Anastasia", 3, philosophy);
    Teacher teacher4 = new Teacher(1, "Olga", 3, literature);
    Teacher teacher5 = new Teacher(1, "Katia", 3, biology);
    Teacher teacher6 = new Teacher(1, "Oleca", 3, chemistry);
    Teacher teacher7 = new Teacher(2, "Sergii", 3, computerScience);
    Teacher teacher8 = new Teacher(1, "Andrii", 3, physics);
    Teacher teacher9 = new Teacher(1, "Olga", 3, economics);
    Teacher teacher10 = new Teacher(1, "Katia", 3, mathematics);


    Study ACP1Study1 = new Study(ACP1, history);
    Study ACP1Study2 = new Study(ACP1, biology);
    Study ACP1Study3 = new Study(ACP1, philosophy);
    Study ACP1Study4 = new Study(ACP1, mathematics);
    Study ACP1Study5 = new Study(ACP1, literature);

    Study ACP2Study1 = new Study(ACP2, computerScience);
    Study ACP2Study2 = new Study(ACP2, physics);
    Study ACP2Study3 = new Study(ACP2, chemistry);
    Study ACP2Study4 = new Study(ACP2, philosophy);
    Study ACP2Study5 = new Study(ACP2, music);

    Study ACP3Study1 = new Study(ACP3, economics);
    Study ACP3Study2 = new Study(ACP3, mathematics);
    Study ACP3Study3 = new Study(ACP3, literature);
    Study ACP3Study4 = new Study(ACP3, biology);
    Study ACP3Study5 = new Study(ACP3, computerScience);

    Study ACP4Study1 = new Study(ACP4, computerScience);
    Study ACP4Study2 = new Study(ACP4, music);
    Study ACP4Study3 = new Study(ACP4, philosophy);
    Study ACP4Study4 = new Study(ACP4, mathematics);
    Study ACP4Study5 = new Study(ACP4, physics);

//    DataBaseServiceImpl createDateBase = new DataBaseServiceImpl();
//        createDateBase.addNewGroup(ACP2);
//        createDateBase.addNewStudent(student2);
//        createDateBase.addNewSubject(history);
//        createDateBase.addNewSubject(biology);
//        createDateBase.addNewTeacher(teacher1);
//        createDateBase.addNewTeacher(teacher2);
//        createDateBase.getGroup(ACP1);
//        createDateBase.getStudent(student1);
//        createDateBase.getSubject(history);
//        createDateBase.getTeacher(teacher2);
}
