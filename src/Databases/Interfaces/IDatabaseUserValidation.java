package Databases.Interfaces;

public interface IDatabaseUserValidation {
    boolean validateUser(String Username, String Password);
    String passwordBuilder(char[] pass);
}
