package jdbcmySql;

/**
 * Created by lost on 12.11.2016.
 */

import java.io.IOException;
import java.util.Properties;

/**
 * Created by serhii on 10/27/16.
 */
public class PropertiesHolder {

  //  private static final Logger LOG = Logger.getLogger(PropertiesHolder.class);
    private static final Properties PROPERTIES = load();

    public static final String APP_PROPERTIES_PATH = "/db_property.properties";

    private static Properties load() {
        Properties properties = new Properties();
        try {
    //        LOG.debug("loading app.properties from classpath");
            properties.load(PropertiesHolder.class.getResourceAsStream(APP_PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String key) {

        return PROPERTIES.getProperty(key);
    }

}