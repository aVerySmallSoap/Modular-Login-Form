package Databases.LoginHandler;

import Databases.LoginHandler.Exceptions.NullInputException;
import Managers.Interfaces.IDatabaseUserRegistration;
import Managers.QueryManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistration implements IDatabaseUserRegistration {
    QueryManager queryManager;
    private int ID_counter = new LoginCredentialsDB().getIDCount();
    public UserRegistration(QueryManager QueryManager){
        this.queryManager = QueryManager;
    }

    @Override
    public boolean RegisterUser(String Username, String Password) {
        try {
            if(Username.equals("") || Password.equals("")){
                throw new NullInputException();
            }else{
            ++ID_counter;
            PreparedStatement pt = queryManager.getDatabaseManagerConnection().prepareStatement(
                    "insert into logins (ID, user_name, pass_word) values (?,?,?)");
            pt.setInt(1, ID_counter);
            pt.setString(2, Username);
            pt.setString(3, Password);
            pt.executeUpdate();
            return true;
            }
        }catch (NullInputException e){
            System.out.println("Null input exception: invalid input as it is null.");
            return false;
        }catch (SQLException e){
            System.out.println("Something happened!\n" + e);
            return false;
        }
    }
}
