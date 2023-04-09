package Databases.LoginHandler.Test;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Managers.DatabaseManager;
import Managers.QueryManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryToLoginCredDBTest {
    QueryManager qm;

    @BeforeEach
    void setUp() {
        qm = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
    }

    @Test
    void getQuery(){
        assertEquals(qm.getModule().getQuery("user_name", "Lirys"), "Lirys");
    }

    @Test
    void selectQuery() {
        assertNotNull(qm.getModule().selectQuery("select * from logins"));
    }

    @Test
    void query() {
        assertEquals(qm.getModule().Query("insert into logins (ID, user_name, pass_word) values (99, 'eek', 'kee')"), 1);
    }


    @AfterAll
    static void afterAll() {
        QueryManager queryManager = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
        queryManager.getModule().Query("delete from logins where ID=99");
    }
}