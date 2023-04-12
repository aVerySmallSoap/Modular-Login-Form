package Databases.UIFunctions;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Databases.LoginHandler.UserRegistration;
import Databases.LoginHandler.UserValidator;
import Managers.DatabaseManager;
import Managers.Interfaces.IDatabaseUserRegistration;
import Managers.Interfaces.IDatabaseUserValidation;
import Managers.QueryManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegisterUserOnClick implements ActionListener {
    QueryManager qm = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
    IDatabaseUserValidation userValidator = new UserValidator(qm);
    IDatabaseUserRegistration userRegistration = new UserRegistration(qm);
    String Username;
    String Password;

    public RegisterUserOnClick(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateUserForRegistry(Username, Password);
    }

    private void validateUserForRegistry(String user, String pass) {
        try {
            if (userValidator.userExists(user)) {
                JOptionPane.showMessageDialog(null, "User already exists!", "Invalid", JOptionPane.ERROR_MESSAGE);
            } else {
                userRegistration.RegisterUser(user, pass);
                JOptionPane.showMessageDialog(null, "Registration Successful!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
