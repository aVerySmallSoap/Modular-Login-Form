package Databases.Interfaces;

public interface IDatabaseUserValidation {
    boolean isValidUser(String Username, String Password);
    String passwordBuilder(char[] pass);
}
