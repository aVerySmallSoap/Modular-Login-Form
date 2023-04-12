package GUI.LoginUI;

import Databases.UIFunctions.RegisterUserOnClick;
import Databases.UIFunctions.ValidateUserOnClick;
import GUI.GraphicalInterface;
import Managers.Interfaces.IPasswordBuilder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@SuppressWarnings("CanBeFinal")
public class LoginUI implements GraphicalInterface {
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

    public void implementEvents(){

        Login.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = IPasswordBuilder.append(passwordField.getPassword());
            new ValidateUserOnClick(user, pass).actionPerformed(e);
        });
        Register.addActionListener(e -> {
            String user = usernameField.getText();
            String pass = IPasswordBuilder.append(passwordField.getPassword());
            new RegisterUserOnClick(user, pass).actionPerformed(e);
        });
    }

}
