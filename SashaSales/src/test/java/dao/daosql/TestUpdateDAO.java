
package dao.daosql;

import init.StartInitSQLDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.daoSQL.implementationssql.CreateCommands;
import ua.artcode.daoSQL.implementationssql.DropCommands;
import ua.artcode.daoSQL.implementationssql.InsertCommands;
import ua.artcode.daoSQL.implementationssql.UpDateCommands;
import ua.artcode.daoSQL.interfaces.CreateDAO;
import ua.artcode.daoSQL.interfaces.DropDAO;
import ua.artcode.daoSQL.interfaces.InsertDAO;
import ua.artcode.daoSQL.interfaces.UpdateDAO;

import static org.hamcrest.Matchers.not;


/**
 * Created by work on 19.11.2016.
 */

public class TestUpdateDAO {

        private CreateDAO createDAO;
        private InsertDAO insertDAO;
        private UpdateDAO updateDAO;
        private DropDAO dropDAO;

        @Before
        public void setUP() {

            createDAO = new CreateCommands();
            insertDAO = new InsertCommands();
            updateDAO = new UpDateCommands();
            dropDAO = new DropCommands();

            StartInitSQLDB.createTables(createDAO);
            StartInitSQLDB.initTables(insertDAO, updateDAO);

        }

        @After
        public void finished() {
            StartInitSQLDB.dropTables(dropDAO);
        }


        @Test
        public void testUpdateStudentsByGroups() {

            boolean updateStudentsByGroupsResult = updateDAO.updateStudentByGroup(2,2);
            Assert.assertThat("Test method update Student By Group", updateStudentsByGroupsResult, not(false));

        }


}

