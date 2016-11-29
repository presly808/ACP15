package jpabush;

import jpabush.dao.GeneralDao;
import jpabush.model.Group;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lost on 26.11.2016.
 */
public class TestGeneralDao extends DaoTextureTest {
    private GeneralDao<Group> dao;
    private Group newgroup;


    @Before
    public void init() {
        newgroup = new Group("APC15",14);
        dao = new GeneralDao<>(manager, Group.class);
    }

    @Test
    public void testInsertGroup() {
        Group groupr = dao.create(newgroup);
        Assert.assertEquals(groupr, newgroup);
    }

    @Test
    public void testDeleteGroup() {
        newgroup = dao.create(newgroup);
        Assert.assertTrue(dao.delete(newgroup, newgroup.getId()));
    }

}
