package jpabush.dao;


import jpabush.model.Group;
import jpabush.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDao extends GeneralDao<Student> {

    public StudentDao(EntityManager manager, Class<Student> studentClass) {
        super(manager, studentClass);
    }

    public StudentDao(EntityManager manager) {
        super(manager, Student.class);
    }

    public List<Student> getAll() {
        TypedQuery<Student> query = manager.createQuery("SELECT b FROM Student b", Student.class);
        return query.getResultList();
    }

    public List<Student> getAllbygroup(Group group) {
        TypedQuery<Student> query = manager.createQuery("SELECT b FROM Student b WHERE b.group=:typeName", Student.class);
        query.setParameter("typeName", group);
        return query.getResultList();
    }


}