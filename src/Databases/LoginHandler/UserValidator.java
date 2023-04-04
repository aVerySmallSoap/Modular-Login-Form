package Databases.LoginHandler;

import DatabaseManager.DatabaseManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DatabaseManager.IDatabaseUserValidation;

public class UserValidator implements IDatabaseUserValidation {
    DatabaseManager DatabaseManager;
    public UserValidator(DatabaseManager DatabaseManager){
        this.DatabaseManager = DatabaseManager;
    }

    @Override
    public boolean isValidUser(String Username, String Password){
        return hasTheSameID(Username, Password);
    }

    @Override
    public String passwordBuilder(char[] pass){ //Retrieves char's from a JPasswordField
        StringBuilder sb = new StringBuilder();
        for (char c: pass) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean hasTheSameID(String Username, String Password) {
        try {
            PreparedStatement pt = DatabaseManager.getDatabaseConnection().prepareStatement(
                    "select ID from logins where user_name=? and pass_word=?");
            pt.setString(1, Username);
            pt.setString(2, Password);
            ResultSet rs = pt.executeQuery();
            return rs.next();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean userExist(String Username){
        try{
            PreparedStatement pt = DatabaseManager.getDatabaseConnection().prepareStatement(
                    "select * from logins where user_name=?");
            pt.setString(1, Username);
           ResultSet rs = pt.executeQuery();
            return rs.next();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
