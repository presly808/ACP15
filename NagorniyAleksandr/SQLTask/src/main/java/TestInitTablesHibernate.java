import university.container.Factory;
import university.dao.crud.CRUDQuery;
import university.exceptions.AppDBException;
import university.models.Group;
import university.models.Subject;
import university.models.SubjectCategory;

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

            SubjectCategory sc = new SubjectCategory("For test3");
            sc.setId(343);

            Subject subject = new Subject("2SB" + System.currentTimeMillis(), sc, "desc");

            crud.addSubject(subject);
            System.out.println("test");
            System.out.println(subject);
        } catch (AppDBException e) {
            e.printStackTrace();
        }
    }
}
