package hibernateService;

import hibernateDB.GroupDao;
import hibernateModel.Group;

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

    public List<Group> getGroupsList(int limit, int offset) {
        return groupDao.getGroupsList(limit, offset);
    }
}
