package Databases.LoginHandler;

import DatabaseManager.DatabaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserValidator implements IDatabaseUserValidation {
    DatabaseManager DatabaseManager;
    public UserValidator(DatabaseManager DatabaseManager){
        this.DatabaseManager = DatabaseManager;
    }

    public boolean isValidUser(String Username, String Password){
        DatabaseManager db = new DatabaseManager(new LoginCredentialsDB());
        return (
                db.getDatabase().getValueFromDB("user_name", Username) != null &&
                        db.getDatabase().getValueFromDB("pass_word", Password) != null) &&
                hasTheSameID(Username, Password);
    }

    @Override
    public String passwordBuilder(char[] pass){ //Retrieves char's from a JPasswordField
        StringBuilder sb = new StringBuilder();
        for (char c: pass) {
            sb.append(c);
        }
        return sb.toString();
    }

    public boolean hasTheSameID(String Username, String Password) {
        DatabaseManager db = new DatabaseManager(new LoginCredentialsDB());
        Username = db.getDatabase().getValueFromDB("user_name", Username);
        Password = db.getDatabase().getValueFromDB("pass_word", Password);
        try {
            PreparedStatement pt = db.getDatabaseConnection().prepareStatement(
                    "select ID from logins where user_name=? and pass_word=?");
            pt.setString(1, Username);
            pt.setString(2, Password);
            ResultSet rs = pt.executeQuery();
            return rs.next();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
