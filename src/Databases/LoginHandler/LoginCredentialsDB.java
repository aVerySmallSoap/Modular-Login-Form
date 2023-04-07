package Databases.LoginHandler;
import Managers.Interfaces.IDatabaseConnection;

import java.sql.*;

public class LoginCredentialsDB implements IDatabaseConnection{

    private int IDCount = getLastestIDCount();

    @Override
    public Connection getConnection() throws SQLException {
        return getThisDatabase();
    }

    @Override
    public boolean closeConnection() throws SQLException {
        getThisDatabase().close();
        return true;
    }

    public int getIDCount(){
        return IDCount;
    }

    private Connection getThisDatabase() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_credits", "root", "root");
    }

    private int getLastestIDCount(){
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