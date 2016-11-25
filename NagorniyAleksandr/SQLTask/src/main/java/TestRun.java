import university.container.Factory;
import university.exceptions.AppDBException;
import university.models.*;
import university.service.Service;

import java.util.List;


public class TestRun {

    public static void main(String[] args) throws AppDBException {

        Service service = Factory.getService();
        Group testGroup = new Group(1, "ACB17");
        SubjectCategory testCategory = new SubjectCategory(1, "Exact");
        Subject testSubject = new Subject(1, "Mathematics",
                testCategory, "Queen of Sciences");


        List<Group> listGroup = service.getGroupList(0, 10);
        System.out.printf("\n   Group list\n");
        listGroup.forEach(System.out::println);

        List<Subject> listSubjects = service.getSubjectsList(0,100);
        System.out.printf("\n   Subjects list\n");
        listSubjects.forEach(System.out::println);

        List<Student> listStudent = service.getStudentsList(0,40);
        System.out.printf("\n   Students list\n");
        listStudent.forEach(System.out::println);

        List<Teacher> listTeacher = service.getTeachersList(0,40);
        System.out.printf("\n   Teachers list\n");
        listTeacher.forEach(System.out::println);


        List<Student> studentsOfGroup = service.getStudentOfGroup(testGroup);
        System.out.printf("\n   Students of group list\n");
        studentsOfGroup.forEach(System.out::println);

        List<Group> groupsBySubject = service.getGroupsBySubject(testSubject, 0,10);
        System.out.printf("\n   Groups by subject list\n");
        groupsBySubject.forEach(System.out::println);

        List<Subject> subjectsThatStudyAllStudents = service.getSubjectsThatStudyAllGroups();
        System.out.printf("\n   Subjects that study all groups\n");
        subjectsThatStudyAllStudents.forEach(System.out::println);

        Teacher maxExpTeacher = service.getTeacherWithMaxExperience();
        System.out.printf("\n   Teacher with max experience\n");
        System.out.println(maxExpTeacher.toString());

        Teacher minExpTeacher = service.getTeacherWithMinExperience();
        System.out.printf("\n   Teacher with min experience\n");
        System.out.println(minExpTeacher.toString());

        int years = 2;
        List<Teacher> teachersWithExpMoreThan = service.getTeachersWithExperienceMoreThanYears(years);
        System.out.printf("\n   Teachers with exp mare than:" + years + " years\n");
        teachersWithExpMoreThan.forEach(System.out::println);

        List<Teacher> teachersWithExpMoreThanThreeYears = service.getTeachersWithExperienceMoreThanThreeYears();
        System.out.printf("\n   Teachers with exp more than three years\n");
        teachersWithExpMoreThanThreeYears.forEach(System.out::println);

        List<Subject> subjectsByCategory = service.getListOfSubjectsByCategory(testCategory);
        System.out.printf("\n   Subjects list by category: " + testCategory.toString() + "\n");
        subjectsByCategory.forEach(System.out::println);

        List<Subject> humanitarianSubjects = service.getListOfHumanitarianSubjects();
        System.out.printf("\n   Humanitarian subjects list\n");
        humanitarianSubjects.forEach(System.out::println);


    }
}
