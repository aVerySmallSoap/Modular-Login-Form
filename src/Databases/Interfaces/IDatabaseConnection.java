package Databases.Interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseConnection {
    Connection getConnection() throws SQLException;

    String getValueFromDB(String Column, String Value);
}
