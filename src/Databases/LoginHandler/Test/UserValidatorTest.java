package Databases.LoginHandler.Test;

import DatabaseManager.DatabaseManager;
import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void passwordBuilder() {
    }

    @Test
    void userExist() {
        assertTrue(validator.userNotExisting("Test"));
    }
}