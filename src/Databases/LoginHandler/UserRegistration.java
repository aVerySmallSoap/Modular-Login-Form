package Databases.LoginHandler;

import Managers.DatabaseManager;
import Managers.Interfaces.IDatabaseUserRegistration;
import Managers.Interfaces.IPasswordBuilder;
import Managers.QueryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistration implements IDatabaseUserRegistration, IPasswordBuilder {
    private QueryManager queryManager;
    private int ID_counter = retrieveLatestIDNUM();
    public UserRegistration(QueryManager Query){
        this.queryManager = Query;
    }

    @Override
    public boolean RegisterUser(String Username, String Password) {
        if(Username.equals("") || Password.equals(""))
            return false;
        try {
            ++ID_counter;
            queryManager = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
            PreparedStatement pt = queryManager.getDatabaseManagerConnection().prepareStatement(
                    "insert into logins (ID, user_name, pass_word) values (?,?,?)");
            pt.setInt(1, ID_counter);
            pt.setString(2, Username);
            pt.setString(3, Password);
            pt.executeUpdate();
            return true;
        }catch (SQLException e){
            return false;
        }
    }

    private int retrieveLatestIDNUM(){
        try {
            queryManager = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
            PreparedStatement pt = queryManager.getDatabaseManagerConnection().prepareStatement(
                    "select count(distinct ID) from logins");
            ResultSet rs = pt.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }else {
                return 1;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
