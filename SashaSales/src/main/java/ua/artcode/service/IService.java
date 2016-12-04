package ua.artcode.service;

import ua.artcode.exceptions.EmptyException;
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
   // List<Student> getAllStudentsByGroup(String nameGroup) throws EmptyException;
    List<Subject> getAllSubjects();
    List<Teacher> getAllTeachers();
    List<Group> getAllGroups();

// service -> add

    Student addStudent(String student_name) throws EmptyException;
    Subject addSubject(String subject_name, String subjects_description) throws EmptyException;
    Teacher addTeacher(String teacher_name, int experience, int subject_id) throws EmptyException;
    Group addGroup(String group_name) throws EmptyException;

// service -> delete

    boolean deleteStudent(String student_name) throws EmptyException;
    boolean deleteSubject(String subject_name) throws EmptyException;
    boolean deleteTeacher(String teacher_name) throws EmptyException;
    boolean deleteGroup(String group_name) throws EmptyException;

// service -> upDate

    Student upDateByGroup(String student_name, String group_name)  throws EmptyException;

// -узнать какие группы изучают математику

    List<Group> getGroupsThatStudySubject(String subject_name) throws EmptyException;

// -какие преподаватель имеют наименьший и наибольший опыт?

    List<Group> groupsThatStudyAllSubjects();

//  -какие преподы преподают больше 3-х лет

    List<Teacher> getTeachersThatWorkMore3Years();

 // - получить список гуманитарных предметов

    List<Subject> getAllGumanitarSubjects();

//  -узнать средний бал студентов по физике (всех и определенной группы)

    double avgMarkBySubjectInUniversity(String subject_name)  throws EmptyException;
    double avgMarkBySubjectInGroup(String subjectName, String groupName) throws EmptyException;

//  -показать группу, в которой более 3-х студентов изучают философию (и выгнать с универа)

    List<Group> groupsInThatMore3StudentsStudyphilosophy();
}
