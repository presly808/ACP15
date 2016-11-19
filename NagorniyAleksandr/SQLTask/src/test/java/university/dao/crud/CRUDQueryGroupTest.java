package university.dao.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import university.dao.QueryCreator;
import university.dao.QueryCreatorImpl;
import university.exceptions.GroupAlreadyExistsException;
import university.exceptions.GroupNotFoundException;
import university.jdbc.DBConnector;
import university.jdbc.DBConnectorMySQL;
import university.models.Group;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by nagornyyalek on 18.11.2016.
 */
public class CRUDQueryGroupTest {

    private static final DBConnector dbConnector;
    private static final QueryCreator queryCreator;

    private Group testGroup;
    private Group groupNotFromDB;

    static {
        dbConnector = new DBConnectorMySQL();
        CRUDQuery crudQuery = new CRUDQueryImpl(dbConnector);
        queryCreator = new QueryCreatorImpl(dbConnector, crudQuery);
    }

    @Before
    public void setUp() throws Exception {

        String testGroupName = "Gr" + System.currentTimeMillis();
        int testGroupId = -1;
        testGroup = new Group(testGroupId, testGroupName);
        queryCreator.addGroup(testGroup);

        int invalidId = -1;
        groupNotFromDB = new Group(invalidId, "Test");

    }

    @After
    public void tearDown() throws Exception {
        queryCreator.deleteGroup(testGroup);
        groupNotFromDB = null;
    }

    @Test
    public void addGroup() throws Exception {
        String testGroupNameForAddTest = "Gr" + System.currentTimeMillis();
        int testGroupIdForAddTest = -1;
        Group testGroupForAddTest = new Group(testGroupIdForAddTest, testGroupNameForAddTest);

        assertTrue(queryCreator.addGroup(testGroupForAddTest));

        //test auto-generation id
        int groupIdAfterAddToDB = testGroup.getId();
        assertThat(groupIdAfterAddToDB, not(equalTo(testGroupIdForAddTest)));

        queryCreator.deleteGroup(testGroupForAddTest);
    }

    @Test
    public void addGroupDuplicate() throws Exception {
        try {
            queryCreator.addGroup(testGroup);
            assertTrue(false);
        } catch (GroupAlreadyExistsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void editGroup() throws Exception {
        String newTestGroupName = "Gr" + System.currentTimeMillis();
        testGroup.setName(newTestGroupName);

        assertTrue(queryCreator.editGroup(testGroup));

        Group updatedGroup = queryCreator.getGroup(testGroup);

        assertThat(newTestGroupName, equalTo(updatedGroup.getName()));
        assertThat(testGroup.getId(), equalTo(updatedGroup.getId()));
    }

    @Test
    public void editGroupNegative() throws Exception {
        try {
            queryCreator.editGroup(groupNotFromDB);
            assertTrue(false);
        } catch (GroupNotFoundException e) {
            assertTrue(true);
        }
    }


    @Test
    public void deleteGroup() throws Exception {
        assertNotNull(queryCreator.getGroup(testGroup));

        assertTrue(queryCreator.deleteGroup(testGroup));

        //try find deleted group
        try {
            queryCreator.getGroup(testGroup);
            assertTrue(false);
        } catch (GroupNotFoundException e) {
            assertTrue(true);
            queryCreator.addGroup(testGroup);
        }
    }

    @Test
    public void deleteGroupNegative() throws Exception {
        try {
            queryCreator.deleteGroup(groupNotFromDB);
            assertTrue(false);
        } catch (GroupNotFoundException e) {
            assertTrue(true);
        }
    }


    @Test
    public void getGroup() throws Exception {
        Group groupFromDB = queryCreator.getGroup(testGroup);

        assertThat(testGroup.getId(), equalTo(groupFromDB.getId()));
        assertThat(testGroup.getName(), equalTo(groupFromDB.getName()));
        assertThat(testGroup, not(equalTo(groupFromDB)));
    }

    @Test
    public void getGroupNegative() throws Exception {

        try {
            queryCreator.getGroup(groupNotFromDB);
            assertTrue(false);
        } catch (GroupNotFoundException e) {
            assertTrue(true);
        }

    }

}