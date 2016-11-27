package university.container;

import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryJPAImpl;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;
import university.service.Service;
import university.service.ServiceImpl;

public class Factory {

    private static DBConnector dbConnector;
    private static CRUDQuery crudQuery;
    private static QueryCreator queryCreator;
    private static Service service;

    static {
        dbConnector = new DBConnectorImpl();
        crudQuery = new CRUDQueryJPAImpl(AppEntityManagerFactory.getInstance());
        queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);
        service = new ServiceImpl(queryCreator);
    }

    public static DBConnector getDBConnector() {
        return dbConnector;
    }

    public static CRUDQuery getCrudQuery() {
        return crudQuery;
    }

    public static QueryCreator getQueryCreator() {
        return queryCreator;
    }

    public static Service getService() {
        return service;
    }
}
