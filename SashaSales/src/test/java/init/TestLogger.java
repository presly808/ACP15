package init;

import ua.artcode.daoSQL.implementationssql.*;
import ua.artcode.daoSQL.interfaces.*;

/**
 * Created by work on 19.11.2016.
 */
public class TestLogger {


    public static void main(String[] args) {

//Logger logger = Logger.getLogger(TestLogger.class);

        CreateDAO createDAO = new CreateCommands();
        InsertDAO insertDAO = new InsertCommands();
        UpdateDAO updateDAO = new UpDateCommands();
        DeleteDAO deleteDAO = new DeleteCommands();
        SelectDAO selectDAO = new SelectCommands();
        DropDAO dropDAO = new DropCommands();

        StartInitSQLDB.createTables(createDAO);
        StartInitSQLDB.initTables(insertDAO, updateDAO);



    }

}
