package ua.artcode.servlets;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Teacher;
import ua.artcode.service.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/addteacher"})
public class AddTeacher extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AddTeacher.class);

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
        req.getRequestDispatcher("/WEB-INF/pages/add-teacher.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // waiting data from the form
        String teacher_name = req.getParameter("name");
        int experience = Integer.parseInt(req.getParameter("experience"));
        int subject_id = Integer.parseInt(req.getParameter("subject_id"));

        if (teacher_name == null) {
            req.setAttribute("errorTitle", "Empty");
            req.setAttribute("errorMessage", "Invalid name");
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        } else {

            try {
                Teacher created = service.addTeacher(teacher_name, experience, subject_id);
                req.setAttribute("teacher", created);
                resp.getWriter().print(created.toString());
                req.getRequestDispatcher("/WEB-INF/pages/teacher-info.jsp").forward(req, resp);
            } catch (EmptyException e) {
                LOG.error(e);
            }
        }


    }

}
