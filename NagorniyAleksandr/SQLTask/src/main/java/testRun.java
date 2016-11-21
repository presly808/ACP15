import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryImpl;
import university.exceptions.AppDBException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;
import university.models.Subject;
import university.service.Service;
import university.service.ServiceImpl;

import java.util.List;


public class testRun {

    public static void main(String[] args) throws AppDBException {

        DBConnector dbConnector = new DBConnectorImpl();
        CRUDQuery crudQuery = new CRUDQueryImpl(dbConnector);
        QueryCreator queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);



        Service service = new ServiceImpl(queryCreator);


            service.getGroupList(0, 10);


        List<Subject> result = service.getSubjectsList(0,100);

        for (Subject subject:
             result) {
            System.out.println(subject.toString());
        }

    }
}
