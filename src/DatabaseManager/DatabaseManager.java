package DatabaseManager;

import Databases.LoginHandler.IDatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseManager {
    private final IDatabaseConnection Database;

    public DatabaseManager(IDatabaseConnection Database){
        this.Database = Database;
    }

    public Connection getDatabaseConnection(String Schema, String Username, String Password) throws SQLException{
        return this.Database.getConnectionFrom(Schema, Username, Password);
    }

    public Connection getDatabaseConnection(){
        try{
            return this.Database.getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public IDatabaseConnection getDatabase(){
        return this.Database;
    }

}
