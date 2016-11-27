import university.container.Factory;
import university.dao.crud.CRUDQuery;
import university.exceptions.AppDBException;
import university.models.Group;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by aleksandrnagorniy on 26.11.16.
 */
public class TestInitTablesHibernate {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("jpa-task");


        CRUDQuery crud = Factory.getCrudQuery();
        try {
            Group temp = new Group();
            temp.setName("QCP1234");
            crud.addGroup(temp);
        } catch (AppDBException e) {
            e.printStackTrace();
        }
    }
}
