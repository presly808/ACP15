package university.dao.crud;

import org.h2.tools.RunScript;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import university.container.Factory;
import university.dao.QueryCreator;
import university.jdbc.DBConnector;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class PrepareTestDataBase {

    protected static final DBConnector dbConnector = Factory.getDBConnector();
    protected static final String CREATE_TEST_DB_SCRIPT = "/H2StructureScript.sql";
    protected static final String DROP_TEST_DB_SCRIPT = "/H2DropDBScript.sql";

    protected QueryCreator queryCreator = Factory.getQueryCreator();

    @BeforeClass
    public static void initDB() {

        // way #1
        /*
        InputStream is = CRUDGroupAndStudentTest.class.getResourceAsStream(CREATE_TEST_DB_SCRIPT);
        ScriptRunner runner = new ScriptRunner(dbConnector.getConnection());
        runner.runScript(new InputStreamReader(is));
        */

        // way #2
        InputStream is = CRUDGroupAndStudentTest.class.
                getResourceAsStream(CREATE_TEST_DB_SCRIPT);

        try {
            RunScript.execute(dbConnector.getConnection(), new InputStreamReader(is));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // way #3
        /*
        Connection connection = dbConnector.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "RUNSCRIPT FROM 'classpath:/H2StructureScript.sql'");
        preparedStatement.execute();
        */

    }

    @AfterClass
    public static void dropDB() {

        // way #1
        /*InputStream is = CRUDGroupAndStudentTest.class.getResourceAsStream(DROP_TEST_DB_SCRIPT);
        ScriptRunner runner = new ScriptRunner(dbConnector.getConnection());
        runner.runScript(new InputStreamReader(is));*/

        // way #2
        InputStream is = CRUDGroupAndStudentTest.class.
                getResourceAsStream(DROP_TEST_DB_SCRIPT);
        try {
            RunScript.execute(dbConnector.getConnection(), new InputStreamReader(is));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
