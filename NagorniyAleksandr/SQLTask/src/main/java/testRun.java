import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryImpl;
import university.exceptions.GroupNotFoundException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorMySQL;
import university.models.Subject;
import university.service.Service;
import university.service.ServiceImpl;

import java.util.List;

/**
 * Created by aleksandrnagorniy on 20.11.16.
 */
public class testRun {

    public static void main(String[] args) {

        DBConnector dbConnector = new DBConnectorMySQL();
        CRUDQuery crudQuery = new CRUDQueryImpl(dbConnector);
        QueryCreator queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);



        Service service = new ServiceImpl(queryCreator);

        try {
            service.addStudent(null);
        } catch (GroupNotFoundException e) {
            e.printStackTrace();
        }
        List<Subject> result = service.getSubjectsList(1,100);

        for (Subject subject:
             result) {
            System.out.println(subject.toString());
        }

    }
}
