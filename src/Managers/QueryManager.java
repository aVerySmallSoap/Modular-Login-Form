package Managers;

import Managers.Interfaces.IDBQueries;

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

    public DatabaseManager getDatabaseManager(){
        return this.Database;
    }
}
