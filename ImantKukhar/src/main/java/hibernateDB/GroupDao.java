package hibernateDB;

import com.mysql.cj.api.Session;
import hibernateModel.Group;
import model.Subject;
import utils.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class GroupDao {

    private static GroupDao instance;

    public static final String GET_GROUP = "SELECT groups.id, groups.group_Name FROM groups WHERE groups.id = ?";
    public static final String EDIT_GROUP = "UPDATE groups SET group_Name = ? WHERE id = ?";
    public static final String GET_GROUPS_LIST = "from groups";
    public static final String GET_GROUPS_LIST_BY_SUBJECT = "SELECT groups.id, groups.group_Name FROM groups " +
            "INNER JOIN studying ON groups.id = studying.group_id WHERE studying.subject_id = ?";


    public static GroupDao getInstance() {
        if (instance == null)
            instance = new GroupDao();
        return instance;
    }

    public boolean addNewGroup(Group group) {
        EntityManager manager = EntityManagerFactoryService.getInstance().getManagerFactory().createEntityManager();
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
        EntityManager manager = EntityManagerFactoryService.getInstance().getManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Group removedGroup = manager.find(Group.class, group.getId());
        if (removedGroup == null) {
            manager.close();
            return false;
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
        EntityManager manager = EntityManagerFactoryService.getInstance().getManagerFactory().createEntityManager();

        Group foundedGroup = manager.find(Group.class, group.getId());
        if (foundedGroup != null) {
            manager.close();
        } else {
            manager.close();
        }
        return foundedGroup;
    }

    public boolean editGroup(Group updatedGroup) {
        return false;
    }

    public List<Group> getGroupsList(int limit, int offset) {
        EntityManager manager = EntityManagerFactoryService.getInstance().getManagerFactory().createEntityManager();
//        TypedQuery<Group> query = manager.createQuery(GET_GROUPS_LIST, Group.class);
        List<Group> result = (List<Group>) manager.createQuery("select from groups", Group.class);

//        query.setMaxResults(limit);
//        query.setFirstResult(offset);
//        return query.getResultList();
        return result;
    }

    public List<Group> getGroupsListBySubject(Subject subject) {
        List<Group> returnSmth = new ArrayList<>();
        return returnSmth;
    }
}
