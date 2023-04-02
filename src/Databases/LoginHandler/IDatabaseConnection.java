package Databases.LoginHandler;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseConnection {
    Connection getConnectionFrom(String Schema, String Username, String Password) throws SQLException;
    Connection getConnection() throws SQLException;

    boolean closeConnection() throws SQLException;

    String getValueFromDB(String Column, String Value);

}
