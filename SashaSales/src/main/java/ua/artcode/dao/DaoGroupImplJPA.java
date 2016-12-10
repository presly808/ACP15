package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.artcode.model.Group;
import ua.artcode.model.Subject;

import javax.persistence.*;
import java.util.List;

/**
 * Created by work on 27.11.2016.
 */

@Component
public class DaoGroupImplJPA implements DaoGroup<Group> {

    @PersistenceContext
    private EntityManager manager;

    public DaoGroupImplJPA() {
    }



    @Override
    @Transactional
    public Group create(Group group) {

        manager.persist(group);
        return group;
    }

    @Override
    @Transactional
    public boolean delete(String entity_name) {

        Group group = getEntityByName(entity_name, manager);
        manager.remove(group);
        return true;
    }

    @Override
    public Group update(Group group) {
        return null;
    }

    @Override
    @Transactional
    public Group findById(Object id) {

            return manager.find(Group.class, id);
    }

    @Override
    public List<Group> getAll() {

        TypedQuery<Group> query = manager.createQuery("SELECT g FROM Group g", Group.class);
        return query.getResultList();
    }

    @Override
    public List<Group> getGroupsThatStudySubject(String subject_name) {


        TypedQuery<Subject> query1 = manager.createQuery("SELECT s FROM Subject s WHERE s.name = :subject_name", Subject.class);
        query1.setParameter("subject_name", subject_name);
        Subject subject = query1.getSingleResult();


        TypedQuery<Group> query2 = manager.createQuery("SELECT g FROM Group g WHERE (?1) member g.subjectList ", Group.class);
        query2.setParameter(1, subject);
        List<Group> groupList = query2.getResultList();

        return groupList;

    }

    @Override
    public Group getEntityByName(String group_name) {

        TypedQuery<Group> query = manager.createQuery("SELECT g FROM Group g WHERE g.name = :group_name", Group.class);
        query.setParameter("group_name", group_name);
        return query.getSingleResult();
    }

    public Group getEntityByName(String group_name, EntityManager entityManager) {

        TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g WHERE g.name = :group_name", Group.class);
        query.setParameter("group_name", group_name);
        return query.getSingleResult();
    }

}
