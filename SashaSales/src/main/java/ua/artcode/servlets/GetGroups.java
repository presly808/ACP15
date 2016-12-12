package ua.artcode.servlets;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ua.artcode.exceptions.EmptyException;
import ua.artcode.model.Group;
import ua.artcode.service.IService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/getgroups"})
public class GetGroups extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(GetGroups.class);

    private ApplicationContext applicationContext;
    private IService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNumber = Integer.parseInt(req.getParameter("page"));
        int sizePage = Integer.parseInt(req.getParameter("size"));
        int fromIndex = sizePage*pageNumber-sizePage;
        List<Group> grouplistPart = service.getAllFirstFiveGroupsFromIndex(fromIndex, sizePage);
        List<Group> grouplist = service.getAllGroups();
        int sizePageToSite = grouplist.size()/4 + 1;



        if(grouplistPart == null && grouplistPart.size() == 0){
            req.setAttribute("errorTitle", "Empty");
            req.setAttribute("errorMessage", "Invalid name");
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        } else {

                req.setAttribute("sizePageToSite", sizePageToSite);
                req.setAttribute("grouplist", grouplist);
                req.setAttribute("grouplistPart", grouplistPart);
                resp.getWriter().print(grouplist.toString());
                req.getRequestDispatcher("/WEB-INF/pages/get-groups.jsp").forward(req, resp);
        }
    }

    @Override
    public void init() throws ServletException {
        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("app-context");
        service = applicationContext.getBean(IService.class);
    }
}
