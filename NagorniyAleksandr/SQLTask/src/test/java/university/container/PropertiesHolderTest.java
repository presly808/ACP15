package university.container;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by aleksandrnagorniy on 18.11.16.
 */
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