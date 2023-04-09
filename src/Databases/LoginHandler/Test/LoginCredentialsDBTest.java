package Databases.LoginHandler.Test;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Managers.DatabaseManager;
import Managers.QueryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginCredentialsDBTest {
    DatabaseManager db;
    QueryManager qm;

    @BeforeEach
    void setUp() {
        db = new DatabaseManager(new LoginCredentialsDB());
        qm = new QueryManager(db, new QueryToLoginCredDB());
    }

    @Test
    void getDatabaseConnection() throws SQLException {
        assertTrue(db.getDatabaseConnection().isValid(0));
    }

    @Test
    void closeConnection() throws SQLException {
        assertTrue(db.getDatabase().closeConnection());
    }

    @Test
    void getValueFromDB(){
        assertEquals(qm.getModule().getQuery("user_name", "Lirys"), "Lirys");
    }

    @Test
    void getValueError(){
        assertThrows(RuntimeException.class, () -> qm.getModule().getQuery("", ""));
    }
}