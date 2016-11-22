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
        resultGroup.forEach(System.out::println);

        List<Subject> resultSubjects = service.getSubjectsList(0,100);
        resultSubjects.forEach(System.out::println);

        List<Student> resultStudent = service.getStudentsList(0,40);
        resultStudent.forEach(System.out::println);
    }
}
