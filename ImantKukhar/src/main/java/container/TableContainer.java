package container;

import db.UniversityDao;

/**
 * Created by Imant on 28.11.16.
 */
public class TableContainer {

    private UniversityDao universityDao = UniversityDao.getInstance();

    public void initAllTables() {
        createGroupTable();
        createStudentTable();
        createSubjectTable();
        createTeacherTable();
        createStudyingTable();
    }

    private void createGroupTable() {

        String createGroupTable = "CREATE TABLE IF NOT EXISTS groups " +
                " (id INTEGER not NULL AUTO_INCREMENT, " +
                " PRIMARY KEY (id), " +
                " group_Name VARCHAR(25) not NULL)";
        universityDao.createTableByRequest(createGroupTable);
    }

    private void createStudentTable() {

        String createStudentTable = "CREATE TABLE IF NOT EXISTS students " +
                " (id INTEGER not NULL AUTO_INCREMENT, " +
                " PRIMARY KEY (id), " +
                " student_Name VARCHAR(25) not NULL, " +
                " group_id INTEGER DEFAULT NULL, " +
                " FOREIGN KEY (group_id) REFERENCES groups(id))";
        universityDao.createTableByRequest(createStudentTable);
    }

    private void createSubjectTable() {

        String createSubjectTable = "CREATE TABLE IF NOT EXISTS subjects " +
                " (id INTEGER not NULL AUTO_INCREMENT, " +
                " PRIMARY KEY (id)," +
                " subject_Name VARCHAR(25) not NULL," +
                " description VARCHAR(100))";
        universityDao.createTableByRequest(createSubjectTable);
    }

    private void createTeacherTable() {

        String createTeacherTable = "CREATE TABLE IF NOT EXISTS teachers " +
                " (id INTEGER not NULL AUTO_INCREMENT, " +
                " PRIMARY KEY (id)," +
                " teacher_Name VARCHAR(25) not NULL," +
                " experience INTEGER not NULL," +
                " subject_id INTEGER DEFAULT NULL, " +
                " FOREIGN KEY (subject_id) REFERENCES subjects(id))";
        universityDao.createTableByRequest(createTeacherTable);
    }

    private void createStudyingTable() {

        String createStudyingTable = "CREATE TABLE IF NOT EXISTS studying " +
                " (group_id INTEGER not NULL, " +
                " subject_id INTEGER not NULL, " +
                " FOREIGN KEY (group_id) REFERENCES groups(id), " +
                " FOREIGN KEY (subject_id) REFERENCES subjects(id))";
        universityDao.createTableByRequest(createStudyingTable);
    }

    public void fillUpGroupTable() {
        String fillUpGroupTable = "INSERT INTO groups VALUES (1,'ACP1'),(2,'ACP2'),(3,'ACP3'),(4,'ACP4')";
        universityDao.fillUpTableByRequest(fillUpGroupTable);
    }

    public void fillUpStudentTable() {
        String fillUpStudentTable = "INSERT INTO students VALUES (1,'Sasha1', 3), (2,'Sasha1', 1), (3,'Sasha1', 2)";
        universityDao.fillUpTableByRequest(fillUpStudentTable);
    }

    public void fillUpSubjectTable() {
        String fillUpSubjectTable = "INSERT INTO subjects VALUES (1,'Matem', 'Qeen'), (2,'Fisra', 'top subject'), (3,'Fisika', 'takoe')";
//        String fillUpSubjectTable = "";
        universityDao.fillUpTableByRequest(fillUpSubjectTable);
    }

    public void fillUpTeacherTable() {
        String fillUpTeacherTable = "INSERT INTO teachers VALUES (1,'Anna', 9, 2), (2,'Viktoria', 5, 1), (3,'Ira', 2, 3)";
//        String fillUpTeacherTable = "";
        universityDao.fillUpTableByRequest(fillUpTeacherTable);
    }

    public void fillUpStudyingTable() {
        String fillUpStudyingTable = "INSERT INTO studying VALUES (1,3), (2,1), (3,2)";
//        String fillUpStudyingTable = "";
        universityDao.fillUpTableByRequest(fillUpStudyingTable);
    }
}
