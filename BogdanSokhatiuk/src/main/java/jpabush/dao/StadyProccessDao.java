package jpabush.dao;

import jpabush.model.StadyProccess;
import jpabush.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by lost on 01.12.2016.
 */
public class StadyProccessDao extends GeneralDao<StadyProccess> {
    public StadyProccessDao(EntityManager manager) {
        super(manager, StadyProccess.class);
    }

    public List<Student> getBestStudent() {
        TypedQuery<Student> query = manager.createQuery("SELECT b.student FROM StadyProccess  b WHERE b.mark= (SELECT max(b.mark) FROM StadyProccess  b))", Student.class);
        return query.getResultList();
    }
}
