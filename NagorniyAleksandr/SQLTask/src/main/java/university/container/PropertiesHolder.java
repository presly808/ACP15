package university.container;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHolder {

    //PATH config files
    public static final String PROPERTIES_FILE_PATH = "/jdbc.properties";

    private static Properties properties = load();

    private static Properties load() {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesHolder.class.getResourceAsStream(PROPERTIES_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String get(String key) {
        return properties == null ? null : properties.getProperty(key);
    }


}
