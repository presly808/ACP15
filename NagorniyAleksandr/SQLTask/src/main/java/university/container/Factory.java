package university.container;

import university.dao.QueryCreator;
import university.dao.QueryCreatorJPAImpl;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryJPAImpl;
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
        if (entityManagerFactory == null) {
            entityManagerFactory = AppEntityManagerFactory.getEntityManagerFactory();
        }

        return entityManagerFactory;
    }

    public static CRUDQuery getCrudQuery() {
        if (crudQuery == null) {
            crudQuery = new CRUDQueryJPAImpl(getEntityManagerFactory());
        }

        return crudQuery;
    }

    public static QueryCreator getQueryCreator() {
        if (queryCreator == null) {
            queryCreator = new QueryCreatorJPAImpl(getEntityManagerFactory(), getCrudQuery());
        }

        return queryCreator;
    }

    public static Service getService() {
        if (service == null) {
            service = new ServiceImpl(getQueryCreator());
        }

        return service;
    }
}
