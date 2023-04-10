package Managers.Interfaces;

import java.sql.SQLException;

public interface IDatabaseUserValidation {
    boolean isValidUser(String Username, String Password) throws SQLException;
}
