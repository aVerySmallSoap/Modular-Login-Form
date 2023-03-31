package Databases.LoginHandler;

import Databases.DatabaseManager;
import Databases.Interfaces.IDatabaseUserRegistration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistration implements IDatabaseUserRegistration {
    private static int ID_counter = 1;
    private DatabaseManager Database;

    public UserRegistration(DatabaseManager Database){
        this.Database = Database;
    }

    @Override
    public void RegisterUser(String Username, String Password) throws SQLException {
        Database = new DatabaseManager(new Login_CredentialsDB());
        PreparedStatement pt = Database.getDatabaseConnection().prepareStatement(
                "insert into logins (ID, user_name, pass_word) values (?,?,?)");
        pt.setInt(1, ID_counter);
        pt.setString(2, Username);
        pt.setString(3, Password);
        pt.executeUpdate();
        ++ID_counter;
    }

    @Override
    public String passwordBuilder(char[] pass){
        StringBuilder sb = new StringBuilder();
        for (char c: pass) {
            sb.append(c);
        }
        return sb.toString();
    }
}
