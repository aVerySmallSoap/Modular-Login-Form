package Databases.UIFunctions;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Databases.LoginHandler.UserValidator;
import Managers.DatabaseManager;
import Managers.QueryManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class validateOnClick implements ActionListener {
    QueryManager qm = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
    UserValidator userValidator = new UserValidator(qm);
    String Username;
    String Password;

    public validateOnClick(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validateUser(Username, Password);
    }

    private boolean validateUser(String user, String pass){
        if(userValidator.isValidUser(user, pass)){
            JOptionPane.showMessageDialog(null, "Log-in Successful!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "User does not exist!", "Invalid", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
