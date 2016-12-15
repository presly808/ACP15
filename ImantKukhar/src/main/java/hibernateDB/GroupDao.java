package hibernateDB;

import hibernateModel.Group;
import hibernateModel.Subject;
import utils.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class GroupDao {

    private static GroupDao instance;

    public static final String GET_GROUPS_LIST = "SELECT g FROM Group g";
    public static final String GET_GROUPS_LIST_BY_SUBJECT = "SELECT st.groupList FROM Study st WHERE st.subjectList =:parameter ";


    public static GroupDao getInstance() {
        if (instance == null)
            instance = new GroupDao();
        return instance;
    }

    public boolean addNewGroup(Group group) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(group);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public boolean deleteGroup(Group group) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Group removedGroup = manager.find(Group.class, group.getId());
        if (removedGroup == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.remove(removedGroup);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public Group getGroup(Group group) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();

        Group foundedGroup = manager.find(Group.class, group.getId());
        if (foundedGroup != null) {
            manager.close();
        } else {
            manager.close();
        }
        return foundedGroup;
    }

    public boolean editGroup(Group updatedGroup) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        if (manager.find(Group.class, updatedGroup.getId()) == null) {
            manager.close();
        }

        try {
            transaction.begin();
            manager.merge(updatedGroup);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
        return false;
    }

    public List<Group> getGroupsList(int limit, int offset) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Group> query = manager.createQuery(GET_GROUPS_LIST, Group.class);

        query.setMaxResults(limit);
        query.setFirstResult(offset);
        return query.getResultList();
    }

    public List<Group> getGroupsListBySubject(Subject subject) {
        EntityManager manager = EntityManagerFactoryService.getManagerFactory().createEntityManager();
        TypedQuery<Group> query = manager.createQuery(GET_GROUPS_LIST_BY_SUBJECT, Group.class);
        query.setParameter("parameter", subject);

        return query.getResultList();
    }
}
