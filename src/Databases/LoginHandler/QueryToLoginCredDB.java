package Databases.LoginHandler;

import Managers.DatabaseManager;
import Managers.Interfaces.IDBQueries;
import Managers.QueryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryToLoginCredDB implements IDBQueries {
    private QueryManager queryManager = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), this);

    @Override
    public String getQuery(String Column, String Value){
        try {
            PreparedStatement pt = queryManager.getDatabaseManagerConnection().prepareStatement(
                    "select "+Column+" from logins where "+Column+"=?");
            pt.setString(1, Value);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return null;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet selectQuery(String query) {
        try{
            Statement st = queryManager.getDatabaseManagerConnection().createStatement();
            return st.executeQuery(query);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int Query(String query) {
        try{
            Statement st = queryManager.getDatabaseManagerConnection().createStatement();
            return st.executeUpdate(query);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
