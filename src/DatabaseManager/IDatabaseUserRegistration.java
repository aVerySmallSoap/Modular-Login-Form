package DatabaseManager;

import java.sql.SQLException;

public interface IDatabaseUserRegistration {

    boolean RegisterUser(String Username, String Password) throws SQLException;
    String passwordBuilder(char[] pass);
}
