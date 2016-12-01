package jpabush.dao;

import jpabush.model.Subject;
import jpabush.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by lost on 30.11.2016.
 */
public class TeacherDao extends GeneralDao<Teacher> {

    public TeacherDao(EntityManager manager, Class<Teacher> teacherClass) {
        super(manager, teacherClass);
    }

    public TeacherDao(EntityManager manager) {
        super(manager, Teacher.class);
    }

    public List<Teacher> getAll() {
        TypedQuery<Teacher> query = manager.createQuery("SELECT b FROM Teacher b", Teacher.class);
        return query.getResultList();
    }

    public List<Teacher> getAllbySubject(Subject subject) {
        TypedQuery<Teacher> query = manager.createQuery("SELECT b FROM Teacher b WHERE b.subject=:typeName", Teacher.class);
        query.setParameter("typeName", subject);
        return query.getResultList();
    }


}


