package university.container;

import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.dao.QueryCreatorJPAImpl;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryJPAImpl;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;
import university.service.Service;
import university.service.ServiceImpl;

import javax.persistence.EntityManagerFactory;

public class Factory {

    private static EntityManagerFactory entityManagerFactory;
    private static CRUDQuery crudQuery;
    private static QueryCreator queryCreator;
    private static Service service;

    static {
        entityManagerFactory = AppEntityManagerFactory.getEntityManagerFactory();
        crudQuery = new CRUDQueryJPAImpl(entityManagerFactory);
        queryCreator = new QueryCreatorJPAImpl(entityManagerFactory, crudQuery);
        service = new ServiceImpl(queryCreator);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
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
