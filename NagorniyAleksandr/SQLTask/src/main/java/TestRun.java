import university.container.ServiceHolder;
import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryImpl;
import university.exceptions.AppDBException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;
import university.models.Group;
import university.models.Student;
import university.models.Subject;
import university.service.Service;
import university.service.ServiceImpl;

import java.util.List;


public class TestRun {

    public static void main(String[] args) throws AppDBException {

        Service service = ServiceHolder.getInstance();

        List<Group> resultGroup = service.getGroupList(0, 10);
        for (Group group : resultGroup) {
            System.out.println(group);
        }

        List<Subject> resultSubjects = service.getSubjectsList(0,100);
        for (Subject subject : resultSubjects) {
            System.out.println(subject);
        }

        List<Student> resultStudent = service.getStudentsList(0,40);
        for (Student student : resultStudent) {
            System.out.println(student);
        }



    }
}
