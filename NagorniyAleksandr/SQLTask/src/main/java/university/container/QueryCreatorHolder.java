package university.container;

import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.dao.crud.CRUDQuery;
import university.dao.crud.CRUDQueryImpl;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorImpl;

public class QueryCreatorHolder {

    private static QueryCreator queryCreatorInstance = init();

    private static QueryCreator init() {
        DBConnector dbConnector = new DBConnectorImpl();
        CRUDQuery crudQuery = new CRUDQueryImpl(dbConnector);
        QueryCreator queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);

        return queryCreator;
    }

    public static QueryCreator getInstance() {
        return queryCreatorInstance;
    }
}
