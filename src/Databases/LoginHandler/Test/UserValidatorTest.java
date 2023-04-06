package Databases.LoginHandler.Test;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.UserValidator;
import Managers.DatabaseManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserValidatorTest {
    UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator(new DatabaseManager(new LoginCredentialsDB()));
    }

    @Test
    void isValidUser() {
        assertTrue(validator.isValidUser("Lirys","Gwyn"));
    }

    @Test
    void userExist() {
        assertFalse(validator.userExists(""));
    }
}