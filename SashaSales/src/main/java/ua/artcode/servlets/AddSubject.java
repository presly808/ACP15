package ua.artcode.servlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.Group;
import ua.artcode.model.Subject;
import ua.artcode.service.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/addsubject"})
public class AddSubject extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AddSubject.class);

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
        req.getRequestDispatcher("/WEB-INF/pages/add-Subject.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // waiting data from the form
  /*      String subject_name = req.getParameter("subject_name");
        String subject_description = req.getParameter("subject_description");*/
        String subject_name = req.getParameter("name");
        String subject_description = req.getParameter("description");

        if(subject_name == null){
            req.setAttribute("errorTitle", "Empty");
            req.setAttribute("errorMessage", "Invalid name");
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        } else {

            try {
                Subject created = service.addSubject(subject_name, subject_description);
                req.setAttribute("subject", created);
                resp.getWriter().print(created.toString());
                req.getRequestDispatcher("/WEB-INF/pages/subject-info.jsp").forward(req, resp);
            } catch (EmptyException e) {
                LOG.error(e);
            }
        }


    }

}
