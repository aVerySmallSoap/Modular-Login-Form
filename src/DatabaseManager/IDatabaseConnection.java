package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseConnection {
    Connection getConnection() throws SQLException;

    boolean closeConnection() throws SQLException;

    String getValueFromDB(String Column, String Value);

}