package university.container;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PropertiesHolderTest {
    @Test
    public void get() throws Exception {

        assertNotNull(PropertiesHolder.get("JDBC_DRIVER_CLASS_NAME"));
        assertNotNull(PropertiesHolder.get("JDBC_URL"));
        assertNotNull(PropertiesHolder.get("JDBC_USER"));
        assertNotNull(PropertiesHolder.get("JDBC_PASS"));

        assertNull(PropertiesHolder.get("Invalid property"));
    }

}