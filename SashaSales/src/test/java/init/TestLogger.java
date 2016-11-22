package init;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import ua.artcode.daoSQL.implementations.*;
import ua.artcode.daoSQL.interfaces.*;
import ua.artcode.service.IServiceImpl;
import ua.artcode.util.*;

/**
 * Created by work on 19.11.2016.
 */
public class TestLogger {


    public static void main(String[] args) {

        CreateDAO createDAO = new CreateCommands();
        InsertDAO insertDAO = new InsertCommands();
        UpdateDAO updateDAO = new UpDateCommands();
        DeleteDAO deleteDAO = new DeleteCommands();
        SelectDAO selectDAO = new SelectCommands();
        DropDAO dropDAO = new DropCommands();

        StartInitDB.createTables(createDAO);
        StartInitDB.initTables(insertDAO, updateDAO);



    }

}
