package Databases.LoginHandler;

import Databases.DatabaseManager;
import Databases.Interfaces.IDatabaseUserValidation;

public class UserValidator implements IDatabaseUserValidation {
    DatabaseManager DatabaseManager;
    public UserValidator(DatabaseManager DatabaseManager){
        this.DatabaseManager = DatabaseManager;
    }

    public boolean validateUser(String Username, String Password){
        DatabaseManager db = new DatabaseManager(new Login_CredentialsDB());
        return (db.getDatabase().getValueFromDB("user_name", Username)) != null &&
                db.getDatabase().getValueFromDB("pass_word", Password) != null;
    } //TODO: Check for IDs for validation

    @Override
    public String passwordBuilder(char[] pass){ //Retrieves char's from a JPasswordField
        StringBuilder sb = new StringBuilder();
        for (char c: pass) {
            sb.append(c);
        }
        return sb.toString();
    }
}
