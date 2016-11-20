package init;

import java.util.Random;

/**
 * Created by work on 13.11.2016.
 */
public class TestDataForDBSQL {



    public static String generateName(){

        String [] firstNames = {"Katerina", "Elena", "Artur", "Ivan", "Sergey", "Petr", "Nikolay", "Stepan", "Pavel", "Gennadiy", "Ulyana",
                                "Yana", "Yuliya", "Vladimir", "Igor", "Aleksandr", "Hanna", "Irina", "Antonina", "Vladislav"};
        String [] lastNames = {"Poroshenko", "Klichko", "Zelenskiy", "Koshevoy", "Timoshenko", "Lyashko", "Putin", "Aksenov", "Kernes",
                                "Avakov", "Moskal", "Shevchenho", "Hmelnizkiy", "Zhirinovskiy", "Tramp", "Kuchma", "Yanukovich",
                                "Kirkorov", "Baskov", "Galkin"};
        int index1 = (int) (20 - Math.random() * 20);
        int index2 = (int) (20 - Math.random() * 20);

        return firstNames[index1] + " " + lastNames[index2];

    }

    public static String[] generateSubjectName(){

        String [] subjectNames = {"Mathematics", "English", "Ukrainian", "Java programming", "Phisics", "Philologia", "Economics",
                                "Philosophy", "Music", "Statistics", "Linguistics", "Biochemistry", "Botany", "Chemistry", "Criminal Justice", "Geography",
                                "History", "Management", "Painting", "Media and Communication", "Journalism"};

        return subjectNames;
    }

    public static String generateGroupName(){

        String [] firstPart = {"Base", "ACO", "ACP", "Velikie", "Izvestnie", "Uvazhaemie", "Politichesskaya", "Regionu", "Opoziciya", "EdinayaUkraine"};
        String [] secondPart = {"1","2","3", "4","5","6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        int index1 = (int) (10 - Math.random() * 10);
        int index2 = (int) (16 - Math.random() * 16);

        return firstPart[index1] + "-" + secondPart[index2];
    }


}
