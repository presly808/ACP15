package ua.artcode.servlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.dao.DaoGroup;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.service.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by work on 10.12.2016.
 */
@WebServlet(urlPatterns = {"/addgroup"})
public class Add_Group extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(Add_Group.class);

    private ApplicationContext applicationContext;
    private IService service;

    @Override
    public void init() throws ServletException {
        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("app-context");
        service = applicationContext.getBean(IService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/add-group.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // waiting data from the form
        String group_name = req.getParameter("group_name");

        if(group_name == null){
            // redirect
            resp.sendRedirect("http/error.jsp");
        } else {

            try {
                Group created = service.addGroup(group_name);
                req.setAttribute("group", created);
                req.getRequestDispatcher("/WEB-INF/pages/group-info.jsp").forward(req, resp);
            } catch (EmptyException e) {
                LOG.error(e);
            }
        }


    }

}
