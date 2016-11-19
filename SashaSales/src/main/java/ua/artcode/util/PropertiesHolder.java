package ua.artcode.util;

import java.io.*;
import java.util.Properties;

/**
 * Created by work on 12.11.2016.
 */
public class PropertiesHolder {


    public static final String PATH_FOR_PROPERTY_FILE = "src/main/resources/db.properties";

    public static String getProperty(String value) {

        Properties properties = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(PATH_FOR_PROPERTY_FILE);
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(value);
    }

    public static boolean addProperty(String nameDB) {

        String partURL = "URL_JDBC_" + nameDB.toUpperCase() + " = jdbc:mysql://localhost:3306/";
        String querry = "URL_JDBC_" + nameDB.toUpperCase();

        String searchURL = PropertiesHolder.getProperty(querry);
        if (searchURL == null){

            try( FileWriter fw = new FileWriter(PATH_FOR_PROPERTY_FILE, true)) {
                fw.write(partURL + nameDB + "\n");
                fw.close();
                IO.write(querry);

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        }

        return true;
    }

}
