package Databases.LoginHandler;
import Managers.Interfaces.IDatabaseConnection;

import java.sql.*;

public class LoginCredentialsDB implements IDatabaseConnection{

    @Override
    public Connection getConnection(){
        return getThisDatabase();
    }

    @Override
    public boolean closeConnection(){
        try{
            getThisDatabase().close();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private Connection getThisDatabase(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_credits", "root", "root");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}