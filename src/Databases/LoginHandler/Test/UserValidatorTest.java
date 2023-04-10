package Databases.LoginHandler.Test;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Databases.LoginHandler.UserValidator;
import Managers.DatabaseManager;
import Managers.QueryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserValidatorTest {
    UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator(new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB()));
    }

    @Test
    void isValidUser() {
        assertTrue(validator.isValidUser("Lirys","Gwyn"));
    }

    @Test
    void userDoesNotExist() {
        assertFalse(validator.userExists(""));
    }

    @Test
    void userDoesExit() {
        assertTrue(validator.userExists("Lirys"));
    }
}