package ua.artcode.util;

import java.io.*;

/**
 * Created by work on 15.11.2016.
 */
public class IO {

    public static final String PATH_FOR_PROPERTY_NAME = "src/main/resources/propertyName.txt";

    public static boolean write(String propertyName) {

        try( FileWriter fw = new FileWriter(PATH_FOR_PROPERTY_NAME)) {
            fw.write(propertyName);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static String read() {

        String str = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH_FOR_PROPERTY_NAME));
            str = br.readLine();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }

        return str;
    }


}
