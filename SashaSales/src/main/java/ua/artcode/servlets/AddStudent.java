package ua.artcode.servlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
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

@WebServlet(urlPatterns = {"/addstudent"})
public class AddStudent  extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AddStudent.class);

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
        req.getRequestDispatcher("/WEB-INF/pages/add-student.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // waiting data from the form
        String student_name = req.getParameter("student_name");

        if(student_name == null){
            // redirect
            resp.sendRedirect("http/error.jsp");
        } else {

            try {
                Student created = service.addStudent(student_name);
                req.setAttribute("student", created);
                req.getRequestDispatcher("/WEB-INF/pages/student-info.jsp").forward(req, resp);
            } catch (EmptyException e) {
                LOG.error(e);
            }
        }


    }

}

