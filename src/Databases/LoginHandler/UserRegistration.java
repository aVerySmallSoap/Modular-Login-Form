package Databases.LoginHandler;

import Managers.Interfaces.IDatabaseUserRegistration;
import Managers.Interfaces.IPasswordBuilder;
import Managers.QueryManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistration implements IDatabaseUserRegistration, IPasswordBuilder {
    QueryManager queryManager;
    private int ID_counter = new LoginCredentialsDB().getIDCount();
    public UserRegistration(QueryManager QueryManager){
        this.queryManager = QueryManager;
    }

    @Override
    public boolean RegisterUser(String Username, String Password) {
        if(Username.equals("") || Password.equals(""))
            return false;
        try {
            ++ID_counter;
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
}
