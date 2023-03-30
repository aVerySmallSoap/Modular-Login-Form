package Databases.LoginHandler;
import Databases.Interfaces.IDatabaseConnection;

import java.sql.*;

public class Login_CredentialsDB implements IDatabaseConnection {

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_credits", "root", "24112021");
    }

    @Override
    public String getValueFromDB(String Column, String Value){
        try {
            PreparedStatement pt = getConnection().prepareStatement("select "+ Column +" from logins where "+Column+" = ?");
            pt.setString(1, Value);
            pt.executeQuery();
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }else{
                return null;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}