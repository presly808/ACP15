package logger;

import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;

import java.io.IOException;


public class Logging {

    public static void main(String[] args) throws IOException {
        // create
        ConsoleAppender console = new ConsoleAppender(new PatternLayout("%r [%t] %-5p %c %C %L %l  %x - %m%n"));
        Logger parent = Logger.getLogger("ua.artcode.week7");
        parent.addAppender(console);
        parent.setLevel(Level.INFO);

        Logger child = Logger.getLogger("ua.artcode.week7.logging");
        child.addAppender(console);
        child.setLevel(Level.INFO);

        Logger child2 = Logger.getLogger(Logging.class);
        child2.setLevel(Level.DEBUG);

        //config


        child2.addAppender(new FileAppender(new XMLLayout(),"log.xml"));
        child2.addAppender(console);
        //using

        child2.debug("child2 debug");





    }
}
