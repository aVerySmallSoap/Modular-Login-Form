package Databases.Test;

import Databases.DatabaseManager;
import Databases.LoginHandler.Login_CredentialsDB;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class Login_CredentialsDBTest {
    DatabaseManager db = new DatabaseManager(new Login_CredentialsDB());

    @Test
    void getConnection() throws SQLException {
        assertTrue(db.getDatabaseConnection().isValid(0));
    }

    @Test
    void closeConnection() throws SQLException {
        assertTrue(db.getDatabase().closeConnection());
    }

    @Test
    void getValueFromDB() {
    }
}