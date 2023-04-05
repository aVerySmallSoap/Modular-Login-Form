package GUI.LoginUI;
import DatabaseManager.DatabaseManager;
import Databases.LoginHandler.UserRegistration;
import Databases.LoginHandler.UserValidator;
import Databases.LoginHandler.LoginCredentialsDB;
import GUI.GraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginUI implements GraphicalInterface {

    DatabaseManager Database = new DatabaseManager(new LoginCredentialsDB());
    UserValidator userValidator = new UserValidator(Database);
    UserRegistration userRegistration = new UserRegistration(Database);

    final Dimension DIMENSIONS = new Dimension(500,500);
    JFrame frame = new JFrame();
    JPanel fieldsPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel passPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JLabel textTitle = new JLabel("SimpleApp");
    JLabel userLabel = new JLabel("Username: ");
    JLabel passLabel = new JLabel("Password: ");
    JTextField usernameField = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20);
    JPanel Buttons = new JPanel();
    JButton Login = new JButton("Log-in");
    JButton Register = new JButton("Register");


     public void Draw(){
        frame.setSize(DIMENSIONS);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Simple App");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(Box.createRigidArea(new Dimension(0, 50)));
        frame.add(titlePanel);
        frame.add(fieldsPanel);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
        Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        passPanel.setLayout(new BoxLayout(passPanel, BoxLayout.Y_AXIS));

        titlePanel.add(textTitle);
        fieldsPanel.add(userPanel);
        fieldsPanel.add(passPanel);
        fieldsPanel.setBorder(new EmptyBorder(25,100,0,100));
        userPanel.add(userLabel);
        userPanel.add(usernameField);
        fieldsPanel.add(Box.createRigidArea(new Dimension(200,100)));
        passPanel.add(passLabel);
        passPanel.add(passwordField);

        frame.add(Buttons);
        Buttons.add(Login);
        Buttons.add(Box.createHorizontalStrut(25));
        frame.add(Box.createVerticalStrut(200));
        Buttons.add(Register);
    }

    //TODO: Do not tie functionality with the UI
    public void implementEvents(){
        String user = usernameField.getText();
        String pass = userValidator.append(passwordField.getPassword());

        Login.addActionListener(e -> validateUser(user,pass));

        Register.addActionListener(e -> {
            validateUser(user, pass);
            userRegistration.RegisterUser(user, pass);
        });
    }

    private void validateUser(String user, String pass){
        if(userValidator.userExist(user) && userValidator.isValidUser(user, pass)){
            JOptionPane.showMessageDialog(null, "Registration Successful!", "Successful", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Invalid!", "Invalid", JOptionPane.ERROR_MESSAGE);
        }
    }
}
