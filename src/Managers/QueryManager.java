package Managers;

import Managers.Interfaces.IDBQueries;

import java.sql.Connection;

public class QueryManager{
    IDBQueries Module;
    private DatabaseManager Database;

    public QueryManager(DatabaseManager Database, IDBQueries Module) {
        this.Database = Database;
        this.Module = Module;
    }

    public IDBQueries getModule(){
        return this.Module;
    }

    public Connection getDatabaseManagerConnection(){
        return this.Database.getDatabaseConnection();
    }
}
