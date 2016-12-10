package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import javax.persistence.*;
import java.util.List;

@Repository
public class DaoSubjectImplJPA implements DaoSubject<Subject> {

    @PersistenceContext
    private EntityManager entityManager;

    public DaoSubjectImplJPA() {
    }


    @Override
    @Transactional
    public Subject create(Subject subject) {

        entityManager.persist(subject);
        return subject;
    }

    @Override
    @Transactional
    public boolean delete(String entity_name) {

        Subject subject = getEntityByName(entity_name, entityManager);

        entityManager.remove(subject);
        return true;
    }

    @Override
    public Subject update(Subject subject) {
        return null;
    }

    @Override
    public Subject findById(Object id) {

            Subject subject = entityManager.find(Subject.class, id);
            return subject;
    }

    @Override
    public List<Subject> getAll() {

        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s", Subject.class);
        return query.getResultList();
    }

    @Override
    public Subject getEntityByName(String subject_name) {

        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :subject_name", Subject.class);
        query.setParameter("subject_name", subject_name);
        return query.getSingleResult();
    }

    public Subject getEntityByName(String subject_name, EntityManager entityManager) {

        TypedQuery<Subject> query = entityManager.createQuery("SELECT s FROM Subject s WHERE s.name = :subject_name", Subject.class);
        query.setParameter("subject_name", subject_name);
        return query.getSingleResult();
    }

}
