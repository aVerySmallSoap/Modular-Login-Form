package Databases.LoginHandler.Test;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Databases.LoginHandler.UserRegistration;
import Managers.DatabaseManager;
import Managers.QueryManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
    UserRegistration registration;

    @BeforeEach
    void setUp(){
        registration = new UserRegistration(new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB()));
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

    @Test
    void registerNullUser(){
        assertFalse(registration.RegisterUser("", ""));
    }

    @AfterAll
    static void tearDown() throws SQLException {
        DatabaseManager databaseManager = new DatabaseManager(new LoginCredentialsDB());
        PreparedStatement pt = databaseManager.getDatabaseConnection().prepareStatement(
                "delete from logins where user_name = 'test'");
        pt.executeUpdate();
    }
}