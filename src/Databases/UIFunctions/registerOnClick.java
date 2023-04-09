package Databases.UIFunctions;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Databases.LoginHandler.UserRegistration;
import Databases.LoginHandler.UserValidator;
import Managers.DatabaseManager;
import Managers.QueryManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerOnClick implements ActionListener {
    QueryManager qm = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
    UserValidator userValidator = new UserValidator(qm);
    UserRegistration userRegistration = new UserRegistration(qm);
    String Username;
    String Password;

    public registerOnClick(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateUserForRegistry(Username, Password);
    }


    private boolean validateUserForRegistry(String user, String pass){
        if(userValidator.userExists(user)){
            JOptionPane.showMessageDialog(null, "User already exists!", "Invalid", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            userRegistration.RegisterUser(user, pass);
            JOptionPane.showMessageDialog(null, "Registration Successful!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
}
