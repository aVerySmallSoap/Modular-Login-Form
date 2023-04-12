package Databases.UIFunctions;

import Databases.LoginHandler.LoginCredentialsDB;
import Databases.LoginHandler.QueryToLoginCredDB;
import Databases.LoginHandler.UserValidator;
//import Interfaces.Dashboard;
import Managers.DatabaseManager;
import Managers.Interfaces.IDatabaseUserValidation;
import Managers.QueryManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class ValidateUserOnClick implements ActionListener {
    QueryManager qm = new QueryManager(new DatabaseManager(new LoginCredentialsDB()), new QueryToLoginCredDB());
    IDatabaseUserValidation userValidator = new UserValidator(qm);
    @SuppressWarnings("FieldMayBeFinal")
    private String Username;
    @SuppressWarnings("FieldMayBeFinal")
    private String Password;

    public ValidateUserOnClick(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            validateUser(Username, Password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void validateUser(String user, String pass) throws SQLException {
        if(userValidator.isValidUser(user, pass)){
            JOptionPane.showMessageDialog(null, "Log-in Successful!", "Successful", JOptionPane.INFORMATION_MESSAGE);
//            new WindowManager(new Dashboard()).executeInterface();
        }else{
            JOptionPane.showMessageDialog(null, "User does not exist!", "Invalid", JOptionPane.ERROR_MESSAGE);
        }
    }
}
