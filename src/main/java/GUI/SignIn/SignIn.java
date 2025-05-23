package GUI.SignIn;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SignIn extends JFrame {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 500;

    private final JPanel logo;
    private final JLabel appName;

    private final JPanel formCenter;
    private final UsernameField usernameField;
    private final PasswordField passwordField;

    private final JButton signInButton;

    public SignIn() {
        super("Sign in Food Order");

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.err.println(e);
        }

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        this.logo = new JPanel();
        Dimension d = new Dimension(WIDTH, 80);
        this.logo.setPreferredSize(d);
        this.logo.setMaximumSize(d);
        this.appName = new JLabel("Order factory");
        this.logo.setLayout(new GridBagLayout());
        this.logo.add(this.appName);
        container.add(this.logo, BorderLayout.NORTH);

        this.formCenter = new JPanel();
        this.formCenter.setLayout(new BoxLayout(this.formCenter, BoxLayout.Y_AXIS));
        this.formCenter.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.usernameField = new UsernameField();
        this.passwordField = new PasswordField();
        this.formCenter.add(this.usernameField);
        this.formCenter.add(this.passwordField);

        this.signInButton = new JButton("Sign in");
        this.formCenter.add(this.signInButton);

        container.add(this.formCenter, BorderLayout.CENTER);

        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
