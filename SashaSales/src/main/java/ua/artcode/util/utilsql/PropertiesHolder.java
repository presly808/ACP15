package ua.artcode.util.utilsql;

import java.io.*;
import java.util.Properties;

/**
 * Created by work on 12.11.2016.
 */
public class PropertiesHolder {


    public static String getProperty(String value) {

        Properties properties = new Properties();
        InputStream is = null;

        try {
            is = PropertiesHolder.class.getResourceAsStream(Contstants.PATH_FOR_PROPERTY_FILE_TEST);
            properties.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(value);
    }

    }
