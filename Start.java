import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame {
    public Start() {
        setTitle("Banking System - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(loginBtn);

        add(panel);
        loginBtn.addActionListener(e -> {
    String user = userField.getText().trim();
    String pass = new String(passField.getPassword()).trim();

    if (user.isEmpty() || pass.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter both username and password.");
        return;
    }

    if (Database.validateLogin(user, pass)) {
        JOptionPane.showMessageDialog(this, "Login successful!");
        dispose();
        new Dashboard(user);
    } else {
        JOptionPane.showMessageDialog(this, "Invalid credentials.");
    }
    });
 

        setVisible(true);
    }
}
