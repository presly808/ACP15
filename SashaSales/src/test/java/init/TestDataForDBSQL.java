package init;

import java.util.Random;

/**
 * Created by work on 13.11.2016.
 */
public class TestDataForDBSQL {



    public static String[] generateStudentName(){

        String [] studentNames = {"Katerina Poroshenko", "Elena Klichko", "Artur Zelenskiy", "Ivan Koshevoy", "Sergey Timoshenko",
                                "Petr Lyashko", "Nikolay Putin", "Stepan Aksenov", "Pavel Kernes", "Gennadiy Avakov",
                                "Ulyana Moskal", "Yana Shevchenho", "Yuliya Hmelnizkiy", "Vladimir Zhirinovskiy", "Igor Tramp",
                                "Aleksandr Kuchma", "Hanna Yanukovich", "Irina Kirkorov", "Antonina Baskov", "Vladislav Galkin",
                                "Katerina Galkin", "Elena Poroshenko", "Artur Klichkox", "Ivan Klichko", "Sergey Koshevoy",
                                "Petr Timoshenko", "Nikolay Lyashko", "Stepan Putin", "Pavel Aksenov", "Gennadiy Kernes",
                                "Ulyana Avakov", "Yana Moskal", "Yuliya Shevchenho", "Vladimir Hmelnizkiy", "Igor Zhirinovskiy",
                                "Aleksandr Tramp", "Hanna Kuchma", "Irina Yanukovich", "Antonina Kirkorov", "Vladislav Baskov",
                                "Katerina Baskov", "Elena Galkin", "Artur Poroshenko", "Ivan Klichkox", "Sergey Klichko",
                                "Petr Koshevoy", "Nikolay Timoshenko", "Stepan Lyashko", "Pavel Putin", "Gennadiy Aksenov",
                                "Ulyana Kernes", "Yana Avakov", "Yuliya Moskal", "Vladimir Shevchenho", "Igor Hmelnizkiy",
                                "Aleksandr Zhirinovskiy", "Hanna Tramp", "Irina Kuchma", "Antonina Yanukovich", "Vladislav Kirkorov"
                                };

        return studentNames;

    }

    public static String[] generateTeacherName(){

        String [] teacherNames = {"Katerina Yanukovich", "Elena Kuchma", "Artur Tramp", "Ivan Zhirinovskiy",
                "Sergey Hmelnizkiy", "Petr Shevchenho", "Nikolay Moskal", "Stepan Avakov", "Pavel Kernes",
                "Gennadiy Aksenov", "Ulyana Putin", "Yana Lyashko", "Yuliya Timoshenko", "Vladimir Koshevoy",
                "Igor Zelenskiy", "Aleksandr Klichko", "Hanna Poroshenko", "Irina Galkin", "Antonina Baskov",
                "Vladislav Kirkorov"};

        return teacherNames;

    }

    public static String[] generateSubjectName(){

        String [] subjectNames = {"Mathematics", "English", "Ukrainian", "Java programming", "Phisics", "Philosofia", "Economics",
                                "Philosophy", "Music", "Statistics", "Linguistics", "Biochemistry", "Botany", "Chemistry", "Criminal Justice", "Geography",
                                "History", "Management", "Painting", "Journalism", "Pholology"};

        return subjectNames;
    }

    public static String[] generateGroupName(){

        String [] groups = {"Base16", "ACO16", "ACP16", "Velikie16", "Izvestnie16", "Uvazhaemie16", "Politichesskaya16", "Regionu16", "Opoziciya16", "EdinayaUkraine16"};

        return groups;
    }


}
