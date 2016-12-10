package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.artcode.model.Group;
import ua.artcode.model.Subject;
import ua.artcode.model.Teacher;

import javax.persistence.*;
import java.awt.*;
import java.util.List;


@Repository
public class DaoTeacherImplJPA implements DaoTeacher<Teacher> {

    @PersistenceContext
    private EntityManager entityManager;

    public DaoTeacherImplJPA() {
    }

    @Override
    @Transactional
    public Teacher create(Teacher teacher) {

        Subject subject = teacher.getSubject();

            if (subject.getId() == 0){
                entityManager.persist(subject);
                entityManager.persist(teacher);
            } else {
                entityManager.persist(teacher);
            }

        return teacher;
    }

    @Override
    @Transactional
    public boolean delete(String entity_name) {

        Teacher teacher = getEntityByName(entity_name, entityManager);

        entityManager.remove(teacher);
        return true;
    }

    @Transactional
    public boolean delete1(int entity_name) {

            Teacher teacher = entityManager.find(Teacher.class, 139);
            entityManager.remove(teacher);
        return true;
    }

    @Override
    public Teacher update(Teacher teacher) {
        return null;
    }

    @Override
    @Transactional
    public Teacher findById(Object id) {

            return entityManager.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> getAll() {

        TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return query.getResultList();
    }

    @Override
    public Teacher getEntityByName(String teacher_name) {

        TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t WHERE t.name = :teacher_name", Teacher.class);
        query.setParameter("teacher_name", teacher_name);
        return query.getSingleResult();
    }

    public Teacher getEntityByName(String teacher_name, EntityManager entityManager) {

        TypedQuery<Teacher> query = entityManager.createQuery("SELECT t FROM Teacher t WHERE t.name = :teacher_name", Teacher.class);
        query.setParameter("teacher_name", teacher_name);
        return query.getSingleResult();
    }


}
