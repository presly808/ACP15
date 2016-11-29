package university.dao.crud;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import university.container.Factory;
import university.dao.QueryCreator;

public class PrepareTestDataBase {

    protected static QueryCreator queryCreator;

    @BeforeClass
    public static void initDB() {
        queryCreator = Factory.getQueryCreator();
    }

    @AfterClass
    public static void dropDB() {
        queryCreator = null;
    }
}
