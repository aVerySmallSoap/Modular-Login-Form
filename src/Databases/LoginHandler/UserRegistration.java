package Databases.LoginHandler;

import Databases.DatabaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRegistration implements IDatabaseUserRegistration {
    private DatabaseManager Database;
    private int ID_counter = retrieveLatestIDNUM();
    public UserRegistration(DatabaseManager Database){
        this.Database = Database;
    }

    @Override
    public String passwordBuilder(char[] pass){
        StringBuilder sb = new StringBuilder();
        for (char c: pass) {
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public void RegisterUser(String Username, String Password) throws SQLException {
        ++ID_counter;
        Database = new DatabaseManager(new LoginCredentialsDB());
        PreparedStatement pt = Database.getDatabaseConnection().prepareStatement(
                "insert into logins (ID, user_name, pass_word) values (?,?,?)");
        pt.setInt(1, ID_counter);
        pt.setString(2, Username);
        pt.setString(3, Password);
        pt.executeUpdate();
    }

    private  int retrieveLatestIDNUM(){
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
