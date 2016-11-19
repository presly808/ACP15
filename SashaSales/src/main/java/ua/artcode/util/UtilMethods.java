package ua.artcode.util;

/**
 * Created by work on 18.11.2016.
 */
public class UtilMethods {

    //Проверка, если в файле уже есть название с БД то добавление в файл проперти не нужно, но перезаписать в файл txt
    // потребуется для переключения use DBname. Если name DB нет in property file, то создастся новой название в пропертифайле
    // и перезапишется в txt.

    // Проверка, если такая база данных уже существует, то идет переключение на эту базу.

    public static boolean useDBorCreate(String nameDB){

        String url = "URL_JDBC_" + nameDB.toUpperCase();
        String searchURL = PropertiesHolder.getProperty(url);
        if (searchURL == null){
            PropertiesHolder.addProperty(nameDB); // - создание нового проперти названия (БД) и урл
            return true;
        } else {
            String querry = "URL_JDBC_" + nameDB.toUpperCase();
            IO.write(querry);
            return true;
        }

    }

}
