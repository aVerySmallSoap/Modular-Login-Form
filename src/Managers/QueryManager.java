package Managers;

import Managers.Interfaces.IDBQueries;

public class QueryManager extends DatabaseManager{
    IDBQueries Module;

    public QueryManager(DatabaseManager Database, IDBQueries Module) {
        super(Database.getDatabase());
        this.Module = Module;
    }

    public IDBQueries getModule(){
        return this.Module;
    }
}
