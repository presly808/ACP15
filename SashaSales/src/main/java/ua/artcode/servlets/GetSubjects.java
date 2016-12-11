package ua.artcode.servlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Subject;
import ua.artcode.service.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/getsubjects"})
public class GetSubjects extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(GetSubjects.class);

    private ApplicationContext applicationContext;
    private IService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Subject> subjectlist = service.getAllSubjects();
        if (subjectlist == null && subjectlist.size() == 0) {
            req.setAttribute("errorTitle", "Empty");
            req.setAttribute("errorMessage", "Invalid name");
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        } else {

            req.setAttribute("subjectlist", subjectlist);
            req.getRequestDispatcher("/WEB-INF/pages/get-subjects.jsp").forward(req, resp);
        }
    }

    @Override
    public void init() throws ServletException {
        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("app-context");
        service = applicationContext.getBean(IService.class);
    }
}
