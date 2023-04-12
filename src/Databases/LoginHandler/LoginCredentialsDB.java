package Databases.LoginHandler;
import Managers.Interfaces.IDatabaseConnection;

import java.sql.*;

public class LoginCredentialsDB implements IDatabaseConnection{

    private final int IDCount = getLatestIDCount();

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

    public int getIDCount(){
        return IDCount;
    }

    private Connection getThisDatabase(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_credits", "root", "root");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private int getLatestIDCount(){
        try{
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select COUNT(distinct ID) from logins");
            if(rs.next()) {
                return rs.getInt(1);
            }else {
                return 0;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}