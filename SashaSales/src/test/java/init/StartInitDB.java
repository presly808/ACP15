package init;

import ua.artcode.daoSQL.implementations.SelectCommands;
import ua.artcode.daoSQL.interfaces.SelectDAO;
import ua.artcode.util.UtilMethods;

/**
 * Created by work on 13.11.2016.
 */
public class StartInitDB {

    public static void main(String[] args) throws ClassNotFoundException {

        SelectDAO selectDAO = new SelectCommands();
        String nameTestDB = "testDBForUniversity"; //- название базы данных, которую планируете использовать или которую планируете создать.

       // UtilMethods.useDBorCreate(nameTestDB);



        selectDAO.getGroups().forEach(System.out::println);

       // CreateCommands.createDBSQL(nameTestDB);

        //CreateCommands.createTableGroups();
        //DropCommands.dropTableGroups();

/*        for (int i = 0; i < 8; i++) {
            InsertCommands.addGroup(init.TestDataForDBSQL.generateGroupName());
        }*/

        /*CreateCommands.createTableSubject();*/

/*        for (Subject subject : SelectCommands.getSubjects()) {
            System.out.println(subject.toString());
        }*/

  /*      String[] subjects = init.TestDataForDBSQL.generateSubjectName();
        for (int i = 0; i < 13; i++) {
            InsertCommands.addSubject(subjects[i], "Description " + subjects[i]);
        }*/


 //       CreateCommands.createTableTeachers();

/*        for (int i = 0; i < 12; i++) {
            InsertCommands.addTeacher(init.TestDataForDBSQL.generateName(), (int) (Math.random()*10), i+1);
        }*/

        //CreateCommands.createTableStudents();

 /*       for (int i = 0; i < 30; i++) {
            InsertCommands.addStudent(init.TestDataForDBSQL.generateName());
        }*/

        //CreateCommands.createTableStudy();


    }

}
