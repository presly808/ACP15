package jpabush;

import jpabush.dao.Dao;
import jpabush.dao.GeneralDao;
import jpabush.model.Group;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lost on 26.11.2016.
 */
public class TestGeneralDao extends DaoTexture {
    private GeneralDao<Group> dao;
    private Group group;

    @Before
    public void init() {
        group=new Group("APC15");
        dao = new GeneralDao<>(manager, Group.class);
    }

    @Test
    public void testInsertGroup() {
        Group groupr=dao.create(group);
        Assert.assertEquals(groupr,group);
    }

    @Test
    public void testDeleteGroup() {
        group=dao.create(group);
        Assert.assertTrue(dao.delete(group,group.getId()));
    }

    @After
    public void tearDown(){
        dao=null;
        group=null;
        manager.close();
    }

}
