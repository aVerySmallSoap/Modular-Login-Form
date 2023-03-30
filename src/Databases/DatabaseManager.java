package Databases;

import Databases.Interfaces.IDatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    private final IDatabaseConnection Database;

    public DatabaseManager(IDatabaseConnection Database){
        this.Database = Database;
    }

    public Connection getDatabaseConnection() throws SQLException{
        return this.Database.getConnection();
    }

    public IDatabaseConnection getDatabase(){
        return this.Database;
    }

}
