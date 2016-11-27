package university.container;

import org.apache.log4j.Logger;
import university.exceptions.AppPropertiesException;


import java.io.IOException;
import java.util.Properties;

public class PropertiesHolder {

    //PATH config files
    public static final String PROPERTIES_FILE_PATH = "/jdbc.properties";

    private static final Logger LOGGER = Logger.getLogger(PropertiesHolder.class);

    private static Properties properties = load();

    private static Properties load() {
        Properties properties = new Properties();
        try {
            LOGGER.info("Load properties");
            properties.load(PropertiesHolder.class.getResourceAsStream(PROPERTIES_FILE_PATH));
        } catch (IOException e) {
            LOGGER.error(e.getMessage() + ". Throw: AppPropertiesException");
            throw new AppPropertiesException(e.getMessage());
        }
        return properties;
    }

    public static String get(String key) {
        LOGGER.debug("Request for property=" + key);
        if (properties == null) {
            LOGGER.error("Throw: AppPropertiesException, Can't load properties");
            throw new AppPropertiesException(
                    "Can't load properties");
        }

        String property = properties.getProperty(key);

        if (property == null) {
            LOGGER.error("Throw: AppPropertiesException, " +
                    "\"Not found property for key=\"" + key + "\"");
            throw new AppPropertiesException(
                    "Not found property for key=" + key + "\"");
        }
        return property;
    }
}
