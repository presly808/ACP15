package university.container;

import org.junit.Test;
import university.exceptions.AppPropertiesException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class PropertiesHolderTest {

    @Test
    public void get() throws Exception {

        assertThat(PropertiesHolder.get("JDBC_DRIVER_CLASS_NAME"), notNullValue());
        assertThat(PropertiesHolder.get("JDBC_URL"), notNullValue());
        assertThat(PropertiesHolder.get("JDBC_USER"), notNullValue());
        assertThat(PropertiesHolder.get("JDBC_PASS"), notNullValue());

        try {
            PropertiesHolder.get("Invalid property");
            assertTrue(false);
        } catch (AppPropertiesException e){
            assertTrue(true);
        }
    }
}