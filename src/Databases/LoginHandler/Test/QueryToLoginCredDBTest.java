package Databases.LoginHandler.Test;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Managers.DatabaseManager;
import Managers.QueryManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class QueryToLoginCredDBTest {
    QueryManager qm;

    @BeforeEach
    void setUp() {
        qm = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
    }

    @Test
    void getDatabaseManager(){
        assertNotNull(qm.getDatabaseManager());
    }

    @Test
    void getQuery() throws SQLException{
            assertEquals(qm.getModule().getQuery("user_name", "Lirys"), "Lirys");
    }

    @Test
    void selectQuery() throws SQLException{
            assertNotNull(qm.getModule().selectQuery("select * from logins"));
    }

    @Test
    void query() throws SQLException{
        assertEquals(qm.getModule().Query("insert into logins (ID, user_name, pass_word) values (99, 'eek', 'kee')"), 1);
    }

    @Test
    void queryToNull() {
        assertThrows(RuntimeException.class, () -> qm.getModule().Query("insert into logins (ID, user_name, pass_word) values (0,null,null)"));
    }


    @AfterAll
    static void afterAll() throws SQLException {
        QueryManager queryManager = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
        queryManager.getModule().Query("delete from logins where ID=99");
    }
}