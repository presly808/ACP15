package university.container;

import org.junit.Test;
import university.exceptions.AppPropertiesException;

import static org.junit.Assert.*;

public class PropertiesHolderTest {
    @Test
    public void get() throws Exception {

        assertNotNull(PropertiesHolder.get("JDBC_DRIVER_CLASS_NAME"));
        assertNotNull(PropertiesHolder.get("JDBC_URL"));
        assertNotNull(PropertiesHolder.get("JDBC_USER"));
        assertNotNull(PropertiesHolder.get("JDBC_PASS"));

        try {
            PropertiesHolder.get("Invalid property");
            assertTrue(false);
        } catch (AppPropertiesException e){
            assertTrue(true);
        }
    }
}