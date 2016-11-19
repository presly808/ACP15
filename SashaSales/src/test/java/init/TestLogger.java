package init;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import ua.artcode.daoSQL.implementations.SelectCommands;
import ua.artcode.daoSQL.interfaces.SelectDAO;
import ua.artcode.service.IServiceImpl;
import ua.artcode.util.IO;
import ua.artcode.util.PropertiesHolder;

/**
 * Created by work on 19.11.2016.
 */
public class TestLogger {

    public static void main(String[] args) {

        ConsoleAppender console = new ConsoleAppender(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"));
        Logger logger = Logger.getLogger(IServiceImpl.class);
        logger.addAppender(console);
        logger.setLevel(Level.TRACE);

        /*SelectDAO selectDAO = new SelectCommands();
        try {
            selectDAO.getGroups().forEach(System.out::println);
            logger.info("get list");
        } catch (ClassNotFoundException e) {
            logger.error("get list dont", e);
        }*/

        System.out.println(PropertiesHolder.getProperty(IO.read()));



    }

}
