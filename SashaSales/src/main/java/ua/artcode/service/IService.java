package ua.artcode.service;

import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import java.util.List;

/**
 * Created by work on 12.11.2016.
 */
public interface IService {

// service -> get list

    List<Student> getAllStudents();
    List<Student> getAllStudentsByGroup(String nameGroup);
    List<Subject> getAllSubjects();
    List<Teacher> getAllTeachers();
    List<Group> getAllGroups();

// service -> add

    boolean addStudent(String student_name);
    boolean addSubject(String subject_name, String subjects_description);
    boolean addTeacher(String teacher_name, int experience, int subject_id);
    boolean addGroup(String group_name);

// service -> delete

    boolean deleteStudent(String student_name);
    boolean deleteSubject(String subject_name);
    boolean deleteTeacher(String teacher_name);
    boolean deleteGroup(String group_name);

// service -> upDate

    boolean upDateByGroup(int student_id, int group_id);

// -узнать какие группы изучают математику

    List<Group> groupsThatStudySubject(Subject subject);

// -какие преподаватель имеют наименьший и наибольший опыт?

    List<Group> groupsThatStudyAllSubjects();

//  -какие преподы преподают больше 3-х лет

    List<Teacher> getTeachersThatWorkMore3Years();

 // - получить список гуманитарных предметов

    List<Subject> getAllGumanitarSubjects();

//  -узнать средний бал студентов по физике (всех и определенной группы)

    int avgMarkBySubjectInUniversity(Subject subject);
    int avgMarkBySubjectInGroup(Subject subject, Group group);

//  -показать группу, в которой более 3-х студентов изучают философию (и выгнать с универа)

    List<Group> groupsInThatMore3StudentsStudyphilosophy();

}