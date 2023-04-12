package Managers.Tests;

import Databases.LoginHandler.LoginCredentialsDB;
import Managers.DatabaseManager;
import Managers.Interfaces.IDatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseManagerTest {
    DatabaseManager databaseManager;
    @BeforeEach
    void setUp() {
        databaseManager = new DatabaseManager(new LoginCredentialsDB());
    }

    @Test
    void getDatabaseConnection() throws SQLException {
        assertTrue(databaseManager.getDatabaseConnection().isValid(0));
    }

    @Test
    void getDatabase() {
        assertNotNull(databaseManager.getDatabase());
    }

    @Test
    void noConnectionTest(){
        assertThrows(RuntimeException.class, () -> {
            DatabaseManager noDatabase = new DatabaseManager(new mockDB());
            noDatabase.getDatabaseConnection();
        });
    }
}

class mockDB implements IDatabaseConnection{

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("localhost");
    }

    @SuppressWarnings("RedundantThrows")
    @Override
    public boolean closeConnection() throws SQLException {
        return false;
    }
}