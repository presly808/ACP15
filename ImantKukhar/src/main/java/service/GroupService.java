package service;

import db.GroupDao;
import model.Group;
import model.Subject;

import java.util.List;

/**
 * Created by Imant on 28.11.16.
 */
public class GroupService {

    private GroupDao groupDao = GroupDao.getInstance();

    public boolean addNewGroup(Group group) {
        return groupDao.addNewGroup(group);
    }

    public boolean deleteGroup(Group group) {
        return groupDao.deleteGroup(group);
    }

    public Group getGroup(Group group) {
        return groupDao.getGroup(group);
    }

    public boolean editGroup(Group groupWithNewInfo) {
        return groupDao.editGroup(groupWithNewInfo);
    }

    public List<Group> getGroupsList(int limit, int offset) {
        return groupDao.getGroupsList(limit, offset);
    }

    public List<Group> getGroupsListBySubject(Subject subject) {
        return groupDao.getGroupsListBySubject(subject);
    }
}
