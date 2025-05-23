package GUI.SignIn;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SignIn extends JFrame {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 400;

    public SignIn() {
        super("Sign in Food Order");

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.err.println(e);
        }


        // Create main panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Font
        Font font = new Font("Arial", Font.BOLD, 24);

        // Title
        JLabel titleLabel = new JLabel("Food Order");
        titleLabel.setFont(font);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Center panel for form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.WHITE);

        // Form fields
        Font font2 = new Font("Arial", Font.PLAIN, 14);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(font2);
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(font2);
        JPasswordField passwordField = new JPasswordField();
        JLabel forgotLabel = new JLabel("Forgot password?");
        forgotLabel.setForeground(Color.BLUE);
        forgotLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add components to form panel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(new JLabel()); // Empty label for spacing
        formPanel.add(forgotLabel);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton signUpButton = new JButton("Sign up");
        JButton signInButton = new JButton("Sign in");
        signInButton.setBackground(new Color(0, 120, 255));
        signInButton.setForeground(Color.WHITE);
        buttonPanel.add(signUpButton);
        buttonPanel.add(signInButton);

        // Add panels to main panel
        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add panel to frame
        add(panel);

        // Center the frame
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
