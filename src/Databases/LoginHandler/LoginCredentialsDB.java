package Databases.LoginHandler;
import Managers.Interfaces.IDatabaseConnection;

import java.sql.*;

public class LoginCredentialsDB implements IDatabaseConnection{

    @Override
    public Connection getConnection() throws SQLException {
        return getThisDatabase();
    }

    @Override
    public boolean closeConnection() throws SQLException {
        getThisDatabase().close();
        return true;
    }

    private Connection getThisDatabase() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_credits", "root", "root");
    }

}