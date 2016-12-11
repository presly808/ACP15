package ua.artcode.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitSpringComtextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        String springLocation = sce.getServletContext().getInitParameter("springLocation");
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(springLocation);

        sce.getServletContext().setAttribute("app-context",applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
