package Databases.LoginHandler.Tests;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Databases.LoginHandler.UserValidator;
import Managers.DatabaseManager;
import Managers.Interfaces.IDatabaseUserValidation;
import Managers.QueryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserValidatorTest {
    IDatabaseUserValidation validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator(new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB()));
    }

    @Test
    void isValidUser() throws SQLException {
        assertTrue(validator.isValidUser("Lirys","Gwyn"));
    }

    @Test
    void userDoesNotExist() throws SQLException {
        assertFalse(validator.userExists(""));
    }

    @Test
    void userDoesExit() throws SQLException {
        assertTrue(validator.userExists("Lirys"));
    }
}