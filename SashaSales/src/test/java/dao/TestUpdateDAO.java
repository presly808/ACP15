package dao;

import init.StartInitDB;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.daoSQL.implementations.CreateCommands;
import ua.artcode.daoSQL.implementations.DropCommands;
import ua.artcode.daoSQL.implementations.InsertCommands;
import ua.artcode.daoSQL.implementations.UpDateCommands;
import ua.artcode.daoSQL.interfaces.CreateDAO;
import ua.artcode.daoSQL.interfaces.DropDAO;
import ua.artcode.daoSQL.interfaces.InsertDAO;
import ua.artcode.daoSQL.interfaces.UpdateDAO;

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

            StartInitDB.createTables(createDAO);
            StartInitDB.initTables(insertDAO, updateDAO);

        }

        @After
        public void finished() {
            StartInitDB.dropTables(dropDAO);
        }


        @Test
        public void testUpdateStudentsByGroups() {

            boolean updateStudentsByGroupsResult = updateDAO.updateStudentByGroup(2,2);
            Assert.assertEquals("Test method update Student By Group", true, updateStudentsByGroupsResult);

        }


}

