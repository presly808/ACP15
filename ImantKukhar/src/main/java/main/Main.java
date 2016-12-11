package main;

import db.GroupDao;
import db.StudentDao;
import db.SubjectDao;
import db.TeacherDao;

/**
 * Created by Imant on 20.11.16.
 */
public class Main {
    public static void main(String[] args) {

//        TableContainer tableContainer = new TableContainer();
//        tableContainer.initAllTables();

//        tableContainer.fillUpGroupTable();
//        tableContainer.fillUpStudentTable();
//        tableContainer.fillUpSubjectTable();
//        tableContainer.fillUpTeacherTable();
//        tableContainer.fillUpStudyingTable();


        GroupDao groupDao = new GroupDao();
        StudentDao studentDao = new StudentDao();
        SubjectDao subjectDao = new SubjectDao();
        TeacherDao teacherDao = new TeacherDao();
    }
}
