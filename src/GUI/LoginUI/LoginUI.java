package GUI.LoginUI;
import Databases.DatabaseManager;
import Databases.LoginHandler.UserValidator;
import Databases.LoginHandler.Login_CredentialsDB;
import GUI.GraphicalInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginUI implements GraphicalInterface {

    public void Draw(){
        final Dimension DIMENSIONS = new Dimension(500,500);

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel passPanel = new JPanel();
        JLabel userLabel = new JLabel("Username: ");
        JLabel passLabel = new JLabel("Password: ");
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton Login = new JButton("Log-in");
        JButton Register = new JButton("Register");
        JPanel Buttons = new JPanel();

        frame.setSize(DIMENSIONS);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        passPanel.setLayout(new BoxLayout(passPanel, BoxLayout.Y_AXIS));

        panel.add(userPanel);
        panel.add(passPanel);
        panel.setBorder(new EmptyBorder(100,100,0,100));
        userPanel.add(userLabel);
        userPanel.add(usernameField);
        panel.add(Box.createRigidArea(new Dimension(200,100)));
        passPanel.add(passLabel);
        passPanel.add(passwordField);

        frame.add(Buttons);
        Buttons.add(Login);
        Buttons.add(Box.createHorizontalStrut(25));
        frame.add(Box.createVerticalStrut(200));
        Buttons.add(Register);

        Login.addActionListener(e -> {
            DatabaseManager Database = new DatabaseManager(new Login_CredentialsDB());
            UserValidator userValidator = new UserValidator(Database);
            String user = usernameField.getText();
            String pass = userValidator.passwordBuilder(passwordField.getPassword());
            if(userValidator.validateUser(user, pass)){
                JOptionPane.showMessageDialog(null, "Login successful!", "Successful", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid User!", "Invalid", JOptionPane.ERROR_MESSAGE);
            }
        });
//        Register.addActionListener(e -> {
//
//            String user = usernameField.getText();
//
//            StringBuilder pass = new StringBuilder(" ");
//            for (char c: passwordField.getPassword()) {
//                pass.append(c);
//            }
//                database.registerUser(user, pass.toString().trim());
//        });
    }
}
