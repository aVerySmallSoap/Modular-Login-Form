package Managers.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBQueries {
    String getQuery(String Column, String Value) throws SQLException;
    ResultSet selectQuery(String query) throws SQLException;
    int Query(String query) throws SQLException;
}
