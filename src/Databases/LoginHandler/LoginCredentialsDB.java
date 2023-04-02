package Databases.LoginHandler;
import Databases.Interfaces.IDatabaseConnection;

import java.sql.*;

public class LoginCredentialsDB implements IDatabaseConnection {

    @Override
    public Connection getConnectionFrom(String Schema, String Username, String Password) throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/"+Schema, Username, Password);
    }

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

    @Override
    public String getValueFromDB(String Column, String Value){
        try {
            PreparedStatement pt = getThisDatabase().prepareStatement(
                    "select " + Column + " from logins where " + Column + " = ?"); //Unsafe statement
            pt.setString(1, Value);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return null;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}