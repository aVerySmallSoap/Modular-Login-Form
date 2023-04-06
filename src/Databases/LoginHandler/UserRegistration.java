package Databases.LoginHandler;

import Managers.DatabaseManager;
import Managers.Interfaces.IDatabaseUserRegistration;
import Managers.Interfaces.IPasswordBuilder;
import Managers.QueryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistration implements IDatabaseUserRegistration, IPasswordBuilder {
    private DatabaseManager Database;
    private QueryManager queryManager;
    private int ID_counter = retrieveLatestIDNUM();
    public UserRegistration(DatabaseManager Database){
        this.Database = Database;
    }

    @Override
    public boolean RegisterUser(String Username, String Password) {
        if(Username.equals("") && Password.equals("")) return false;
        try {
            ++ID_counter;
            queryManager= new QueryManager(Database, new LoginCredentialsDB());
            PreparedStatement pt = Database.getDatabaseConnection().prepareStatement(
                    "insert into logins (ID, user_name, pass_word) values (?,?,?)");
            pt.setInt(1, ID_counter);
            pt.setString(2, Username);
            pt.setString(3, Password);
            pt.executeUpdate();
            return true;
        }catch (SQLException e){
            //User already exists
            return false;
        }
    }

    private int retrieveLatestIDNUM(){
        try {
            Database = new DatabaseManager(new LoginCredentialsDB());
            PreparedStatement pt = Database.getDatabaseConnection().prepareStatement(
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
