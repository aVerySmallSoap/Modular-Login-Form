package Managers.Interfaces;

import java.sql.ResultSet;

public interface IDBQueries {
    String getQuery(String Column, String Value);
    ResultSet selectQuery(String query);
    int Query(String query);
}
