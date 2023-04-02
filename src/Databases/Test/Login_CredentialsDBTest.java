package Databases.Test;

import Databases.DatabaseManager;
import Databases.LoginHandler.LoginCredentialsDB;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class LoginCredentialsDBTest {
    DatabaseManager db = new DatabaseManager(new LoginCredentialsDB());

    @Test
    void getDatabaseConnection() throws SQLException {
        assertTrue(db.getDatabaseConnection().isValid(0));
    }

    @Test
    void getDatabaseConnectionFrom() throws SQLException{
        assertTrue(db.getDatabaseConnection("login_credits", "root", "root").isValid(0));
    }

    @Test
    void closeConnection() throws SQLException {
        assertTrue(db.getDatabase().closeConnection());
    }

    @Test
    void getValueFromDB(){
        assertEquals(db.getDatabase().getValueFromDB("user_name", "Lirys"), "Lirys");
    }
}