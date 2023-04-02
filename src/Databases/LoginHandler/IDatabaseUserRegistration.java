package Databases.LoginHandler;

import java.sql.SQLException;

public interface IDatabaseUserRegistration {

    void RegisterUser(String Username, String Password) throws SQLException;
    String passwordBuilder(char[] pass);
}
