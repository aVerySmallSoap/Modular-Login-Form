package Databases.LoginHandler.Test;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.UserRegistration;
import Managers.DatabaseManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRegistrationTest {
    UserRegistration registration;

    @BeforeEach
    void setUp(){
        registration = new UserRegistration(new DatabaseManager(new LoginCredentialsDB()));
    }

    @Test
    void passwordBuilder() {
        char[] c = {'c','h','a','r'};
        assertEquals(registration.append(c), "char");
    }

    @Test
    void registerUser() {
        assertTrue(registration.RegisterUser("test", "Dummy"));
    }

    @AfterAll
    static void tearDown() throws SQLException {
        DatabaseManager databaseManager = new DatabaseManager(new LoginCredentialsDB());
        PreparedStatement pt = databaseManager.getDatabaseConnection().prepareStatement(
                "delete from logins where user_name = 'test'");
        pt.executeUpdate();
    }
}