package Managers.Interfaces;
public interface IDBQueries {
    String getQuery(String Column, String Value);
    default void Query(String query){}
}
