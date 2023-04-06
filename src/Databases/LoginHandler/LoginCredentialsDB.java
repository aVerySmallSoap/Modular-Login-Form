package Databases.LoginHandler;

import DatabaseManager.IDBQueries;
import DatabaseManager.IDatabaseConnection;

import java.sql.*;

public class LoginCredentialsDB implements IDatabaseConnection, IDBQueries {

    @Override
    public Connection getConnection() throws SQLException {
        return getThisDatabase();
    }

    @Override
    public boolean closeConnection() throws SQLException {
        getThisDatabase().close();
        return true;
    }

    @Override
    public String getQuery(String Column, String Value){
        try {
            PreparedStatement pt = getThisDatabase().prepareStatement(
                    "select "+Column+" from logins where "+Column+" = ?");
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

    private Connection getThisDatabase() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_credits", "root", "root");
    }

}